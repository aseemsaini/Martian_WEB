
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object createUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData2],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /* Login Template File */
  def apply/*2.2*/(loginForm: Form[LoginData2])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/stylesheets/index.css">
</head>
<body>
<div class="container">
    """),_display_(/*13.6*/helper/*13.12*/.form(action = routes.authentication.createUserForm)/*13.64*/ {_display_(Seq[Any](format.raw/*13.66*/("""
    """),_display_(/*14.6*/helper/*14.12*/.CSRF.formField),format.raw/*14.27*/("""
    """),format.raw/*15.5*/("""<div class="login-form2">
        <div class="image-container">
            <img src="/assets/images/luna.png">
        </div>
        <h3>MARTIAN</h3>
        <div class="form-group">
            """),_display_(/*21.14*/helper/*21.20*/.inputText(loginForm("Username"), Symbol("maxlength") -> None, Symbol("minlength") -> None, Symbol("class") -> "hidden-input")),format.raw/*21.146*/("""
        """),format.raw/*22.9*/("""</div>
        <div class="form-group">
            """),_display_(/*24.14*/helper/*24.20*/.inputText(loginForm("Email"), Symbol("maxlength") -> None, Symbol("minlength") -> None, Symbol("class") -> "hidden-input", Symbol("required") -> "required", Symbol("pattern") -> "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")),format.raw/*24.251*/("""
        """),format.raw/*25.9*/("""</div>
        <div class="form-group">
            """),_display_(/*27.14*/helper/*27.20*/.inputPassword(loginForm("Password"), Symbol("maxlength") -> None, Symbol("minlength") -> None, Symbol("class") -> "hidden-input")),format.raw/*27.150*/("""
        """),format.raw/*28.9*/("""</div>
        <div class="form-actions">
            <button type="submit">Create Account</button>
        </div>

        <hr class="division-line2">
        <p class = "already">OR</p>
        <p>
            <button type="button" onclick="window.location.href='"""),_display_(/*36.67*/routes/*36.73*/.authentication.login),format.raw/*36.94*/("""'" class="login-account-btn">Login</button>
        </p>


    </div>
    """)))}),format.raw/*41.6*/("""
    """),_display_(/*42.6*/flash/*42.11*/.get("error").map/*42.28*/ { error =>_display_(Seq[Any](format.raw/*42.39*/("""
    """),format.raw/*43.5*/("""<div class="flash-error">
        """),_display_(/*44.10*/error),format.raw/*44.15*/("""
    """),format.raw/*45.5*/("""</div>
    """)))}),format.raw/*46.6*/("""
    """),_display_(/*47.6*/flash/*47.11*/.get("Done").map/*47.27*/ { message =>_display_(Seq[Any](format.raw/*47.40*/("""
    """),format.raw/*48.5*/("""<div class="flash-success">
        """),_display_(/*49.10*/message),format.raw/*49.17*/("""
    """),format.raw/*50.5*/("""</div>
    """)))}),format.raw/*51.6*/("""
"""),format.raw/*52.1*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(loginForm:Form[LoginData2],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)(request,flash)

  def f:((Form[LoginData2]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => (request,flash) => apply(loginForm)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/createUser.scala.html
                  HASH: c46bf641545a9da03b9fefe77e41e3b0b85ec7ef
                  MATRIX: 793->27|971->112|998->113|1225->314|1240->320|1301->372|1341->374|1373->380|1388->386|1424->401|1456->406|1681->604|1696->610|1844->736|1880->745|1960->798|1975->804|2228->1035|2264->1044|2344->1097|2359->1103|2511->1233|2547->1242|2840->1508|2855->1514|2897->1535|3002->1610|3034->1616|3048->1621|3074->1638|3123->1649|3155->1654|3217->1689|3243->1694|3275->1699|3317->1711|3349->1717|3363->1722|3388->1738|3439->1751|3471->1756|3535->1793|3563->1800|3595->1805|3637->1817|3665->1818
                  LINES: 21->2|26->3|27->4|36->13|36->13|36->13|36->13|37->14|37->14|37->14|38->15|44->21|44->21|44->21|45->22|47->24|47->24|47->24|48->25|50->27|50->27|50->27|51->28|59->36|59->36|59->36|64->41|65->42|65->42|65->42|65->42|66->43|67->44|67->44|68->45|69->46|70->47|70->47|70->47|70->47|71->48|72->49|72->49|73->50|74->51|75->52
                  -- GENERATED --
              */
          