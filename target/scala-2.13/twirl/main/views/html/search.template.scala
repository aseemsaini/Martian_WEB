
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

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Seq[scala.Tuple2[String, String]],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(symbolList: Seq[(String, String)])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
    <h1>Search</h1>
</header>

<!--<div class="logo">-->
<!--    <img src="/assets/images/luna_logo.png">-->
<!--</div>-->

<div class="container">
    """),_display_(/*20.6*/if(symbolList.nonEmpty)/*20.29*/ {_display_(Seq[Any](format.raw/*20.31*/("""
    """),format.raw/*21.5*/("""<ul>
        """),_display_(/*22.10*/for((symbol, name) <- symbolList) yield /*22.43*/ {_display_(Seq[Any](format.raw/*22.45*/("""
        """),format.raw/*23.9*/("""<li>
            <p>Symbol: """),_display_(/*24.25*/symbol),format.raw/*24.31*/("""</p>
            <p>Name: """),_display_(/*25.23*/name),format.raw/*25.27*/("""</p>
        </li>
        """)))}),format.raw/*27.10*/("""
    """),format.raw/*28.5*/("""</ul>
    """)))}/*29.7*/else/*29.11*/{_display_(Seq[Any](format.raw/*29.12*/("""
    """),format.raw/*30.5*/("""<p>No search results found.</p>
    """)))}),format.raw/*31.6*/("""
"""),format.raw/*32.1*/("""</div>

<footer class="footer">
    <p>&copy; 2023 Martian. All rights reserved.</p>
</footer>

</body>
</html>

"""))
      }
    }
  }

  def render(symbolList:Seq[scala.Tuple2[String, String]],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(symbolList)(request,flash)

  def f:((Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (symbolList) => (request,flash) => apply(symbolList)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/search.scala.html
                  HASH: 8f89de484ef8afe650b00b47dc5e549dbd64fd95
                  MATRIX: 785->1|969->92|996->93|1375->446|1407->469|1447->471|1479->476|1520->490|1569->523|1609->525|1645->534|1701->563|1728->569|1782->596|1807->600|1866->628|1898->633|1927->645|1940->649|1979->650|2011->655|2078->692|2106->693
                  LINES: 21->1|26->2|27->3|44->20|44->20|44->20|45->21|46->22|46->22|46->22|47->23|48->24|48->24|49->25|49->25|51->27|52->28|53->29|53->29|53->29|54->30|55->31|56->32
                  -- GENERATED --
              */
          