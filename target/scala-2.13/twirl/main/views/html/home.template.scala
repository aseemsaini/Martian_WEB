
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

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Martian | Home</title>
<!--    <link rel="stylesheet" href="/assets/stylesheets/home.css">-->
</head>
<body>
<header>
    <h1>Welcome To Martian</h1>
</header>

<!--<div class="logo">-->
<!--    <img src="/assets/images/luna_logo.png">-->
<!--</div>-->

<div class="container">
    <form method="post" action = """"),_display_(/*20.36*/routes/*20.42*/.finance.searchTicker),format.raw/*20.63*/("""">
        """),_display_(/*21.10*/helper/*21.16*/.CSRF.formField),format.raw/*21.31*/("""
        """),format.raw/*22.9*/("""<label for="symbol">Enter Stock Symbol:</label>
        <input type="text" id="symbol" name="symbol">
        <button type="submit">Search</button>
    </form>
</div>

<footer class="footer">
    <p>&copy; 2023 Martian. All rights reserved.</p>
</footer>

</body>
</html>
"""))
      }
    }
  }

  def render(request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/home.scala.html
                  HASH: 734c63e53499d3882bd4e36b08dfe303e59518e4
                  MATRIX: 749->1|900->59|927->60|1345->451|1360->457|1402->478|1441->490|1456->496|1492->511|1528->520
                  LINES: 21->1|26->2|27->3|44->20|44->20|44->20|45->21|45->21|45->21|46->22
                  -- GENERATED --
              */
          