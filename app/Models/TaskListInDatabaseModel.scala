package Models

import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._
import java.sql.{Date, Timestamp}


class TaskListInDatabaseModel(db: Database)(implicit ec: ExecutionContext) {
  def validate(username: String)(implicit ec: ExecutionContext): Future[Boolean] = {
    db.run(Users.filter(_.username === username).exists.result)
  }

  def validatePass(username:String, password:String):Future[Boolean] = {
    db.run(Users.filter(_.username === username).map(_.password).result.headOption).map{
      case Some(hashedPassword) => BCrypt.checkpw(password,hashedPassword)
      case None => false
    }
  }


  def createUser(username: String, password: String)(implicit ec: ExecutionContext): Future[Unit] = {
    val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
    db.run(Users += UsersRow(-1, username, hashedPassword,"")).map(_ => ())
  }




  def getUserID(username: String): Future[Int] = {
    val userIDquery = Users.filter(_.username === username).map(_.id).result.head
    val result = db.run(userIDquery).map(id => id)
    result
  }



}

