package controllers

import Models.TaskListInDatabaseModel
import org.h2.jdbc.JdbcDatabaseMetaData
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{Await, ExecutionContext, Future}
import Models.Tables.{UsersRow}
import akka.actor.ActorSystem
import akka.stream.Materializer
import play.api.libs.streams.ActorFlow
import actors.ChatActor
import akka.actor.Props
import actors.ChatManager
import java.sql.Timestamp
import javax.inject._

case class LoginData2(username: String, password: String, email: String)

@Singleton
class authentication @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder, ec: ExecutionContext, system: ActorSystem, mat:Materializer)
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {

  private val model = new TaskListInDatabaseModel(db)
  val loginForm = Form(mapping(
    "Username" -> text(3, 10),
    "Password" -> text(8),
    "Email" -> text(100))(LoginData2.apply)(LoginData2.unapply))

  def login = Action { implicit request =>
    Ok(views.html.login2())
  }

  private var user = ""
  private var searchUser = ""

  def home = Action { implicit request =>
    Ok(views.html.home())
  }


  def createUserForm = Action.async { implicit request =>
    val executionContext = scala.concurrent.ExecutionContext.global
    loginForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.createUser(formWithErrors))),
      ld => {
        val username = ld.username
        val password = ld.password
        // Validate if the username already exists
        model.validate(username)(executionContext).flatMap { exists =>
          if (exists) {
            // Username already exists, return a flashing error
            Future.successful(Redirect(routes.authentication.login).flashing("error" -> "USER ALREADY EXIST").withNewSession)
          } else {
            // Username doesn't exist, create a new user
            model.createUser(username, password)(executionContext).map { _ =>
              Redirect(routes.authentication.login).flashing("Done" -> "USER CREATION DONE")
            }(executionContext).recover {
              case _ =>
                Redirect(routes.authentication.createUser).flashing("error" -> "USER CREATION FAILED")
            }(executionContext)
          }
        }(executionContext)
      })
  }

  def createUser = Action { implicit request =>
    Ok(views.html.createUser(loginForm))
  }

  def loginValidate: Action[AnyContent] = Action.async { implicit request =>
    val formData = request.body.asFormUrlEncoded.get
    val username = formData("Username").head
    val password = formData("Password").head
    println(username, password)
    val resultFuture = model.validatePass(username, password)
    resultFuture.flatMap { result =>
      println(result)
      if (result) {
        val sessionData = Map("username" -> username)
        val redirectResult = Redirect(routes.authentication.home).withSession(sessionData.toSeq: _*)
        Future.successful(redirectResult)
      } else {
        val result = Redirect(routes.authentication.login).flashing("error" -> "INVALID CREDENTIALS")
        Future.successful(result)
      }
    }
  }

  def logout = Action { implicit request =>
    Redirect(routes.authentication.login).withNewSession
  }

  def test = Action { implicit request =>
    Ok(views.html.test())
  }

  val manager = system.actorOf(Props[ChatManager](), "Manager")


  def socket = WebSocket.accept[String,String] { request =>
    println("Getting Socket")
    ActorFlow.actorRef {  out =>
      ChatActor.props(out, manager)
    }
  }

}