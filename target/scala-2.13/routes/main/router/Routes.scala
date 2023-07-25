// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_4: controllers.HomeController,
  // @LINE:10
  AsyncController_3: controllers.AsyncController,
  // @LINE:13
  authentication_0: controllers.authentication,
  // @LINE:21
  Assets_1: controllers.Assets,
  // @LINE:24
  finance_2: controllers.finance,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_4: controllers.HomeController,
    // @LINE:10
    AsyncController_3: controllers.AsyncController,
    // @LINE:13
    authentication_0: controllers.authentication,
    // @LINE:21
    Assets_1: controllers.Assets,
    // @LINE:24
    finance_2: controllers.finance
  ) = this(errorHandler, HomeController_4, AsyncController_3, authentication_0, Assets_1, finance_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, AsyncController_3, authentication_0, Assets_1, finance_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.authentication.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.authentication.createUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validate""", """controllers.authentication.loginValidate"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserForm2""", """controllers.authentication.createUserForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.finance.home"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.finance.searchTicker"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.authentication.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """controllers.authentication.test"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """socket""", """controllers.authentication.socket"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_4.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message1_invoker = createInvoker(
    AsyncController_3.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """TaskList Route
 An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_authentication_login2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_authentication_login2_invoker = createInvoker(
    authentication_0.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_authentication_createUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_authentication_createUser3_invoker = createInvoker(
    authentication_0.createUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "createUser",
      Nil,
      "GET",
      this.prefix + """create""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_authentication_loginValidate4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validate")))
  )
  private[this] lazy val controllers_authentication_loginValidate4_invoker = createInvoker(
    authentication_0.loginValidate,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "loginValidate",
      Nil,
      "POST",
      this.prefix + """validate""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_authentication_createUserForm5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserForm2")))
  )
  private[this] lazy val controllers_authentication_createUserForm5_invoker = createInvoker(
    authentication_0.createUserForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "createUserForm",
      Nil,
      "POST",
      this.prefix + """createUserForm2""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_finance_home7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_finance_home7_invoker = createInvoker(
    finance_2.home,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.finance",
      "home",
      Nil,
      "GET",
      this.prefix + """home""",
      """Home Page""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_finance_searchTicker8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_finance_searchTicker8_invoker = createInvoker(
    finance_2.searchTicker,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.finance",
      "searchTicker",
      Nil,
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_authentication_logout9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_authentication_logout9_invoker = createInvoker(
    authentication_0.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_authentication_test10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_authentication_test10_invoker = createInvoker(
    authentication_0.test,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "test",
      Nil,
      "GET",
      this.prefix + """test""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_authentication_socket11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("socket")))
  )
  private[this] lazy val controllers_authentication_socket11_invoker = createInvoker(
    authentication_0.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.authentication",
      "socket",
      Nil,
      "GET",
      this.prefix + """socket""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_4.index)
      }
  
    // @LINE:10
    case controllers_AsyncController_message1_route(params@_) =>
      call { 
        controllers_AsyncController_message1_invoker.call(AsyncController_3.message)
      }
  
    // @LINE:13
    case controllers_authentication_login2_route(params@_) =>
      call { 
        controllers_authentication_login2_invoker.call(authentication_0.login)
      }
  
    // @LINE:14
    case controllers_authentication_createUser3_route(params@_) =>
      call { 
        controllers_authentication_createUser3_invoker.call(authentication_0.createUser)
      }
  
    // @LINE:15
    case controllers_authentication_loginValidate4_route(params@_) =>
      call { 
        controllers_authentication_loginValidate4_invoker.call(authentication_0.loginValidate)
      }
  
    // @LINE:18
    case controllers_authentication_createUserForm5_route(params@_) =>
      call { 
        controllers_authentication_createUserForm5_invoker.call(authentication_0.createUserForm)
      }
  
    // @LINE:21
    case controllers_Assets_versioned6_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(file))
      }
  
    // @LINE:24
    case controllers_finance_home7_route(params@_) =>
      call { 
        controllers_finance_home7_invoker.call(finance_2.home)
      }
  
    // @LINE:25
    case controllers_finance_searchTicker8_route(params@_) =>
      call { 
        controllers_finance_searchTicker8_invoker.call(finance_2.searchTicker)
      }
  
    // @LINE:26
    case controllers_authentication_logout9_route(params@_) =>
      call { 
        controllers_authentication_logout9_invoker.call(authentication_0.logout)
      }
  
    // @LINE:28
    case controllers_authentication_test10_route(params@_) =>
      call { 
        controllers_authentication_test10_invoker.call(authentication_0.test)
      }
  
    // @LINE:29
    case controllers_authentication_socket11_route(params@_) =>
      call { 
        controllers_authentication_socket11_invoker.call(authentication_0.socket)
      }
  }
}
