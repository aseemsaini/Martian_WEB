
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

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Seq[scala.Tuple3[String, String, String]],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(symbolList: Seq[(String, String, String)])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
    """),_display_(/*21.6*/if(symbolList.nonEmpty)/*21.29*/ {_display_(Seq[Any](format.raw/*21.31*/("""
    """),format.raw/*22.5*/("""<ul>
        """),_display_(/*23.10*/for((symbol, name, region) <- symbolList) yield /*23.51*/ {_display_(Seq[Any](format.raw/*23.53*/("""
        """),format.raw/*24.9*/("""<li class="stock-item" data-symbol=""""),_display_(/*24.46*/symbol),format.raw/*24.52*/("""">
            <p>Symbol: """),_display_(/*25.25*/symbol),format.raw/*25.31*/("""</p>
            <p>Name: """),_display_(/*26.23*/name),format.raw/*26.27*/("""</p>
            <p>Region: """),_display_(/*27.25*/region),format.raw/*27.31*/("""</p>
        </li>
        """)))}),format.raw/*29.10*/("""
    """),format.raw/*30.5*/("""</ul>
    """)))}/*31.7*/else/*31.11*/{_display_(Seq[Any](format.raw/*31.12*/("""
    """),format.raw/*32.5*/("""<p>No search results found.</p>
    """)))}),format.raw/*33.6*/("""
"""),format.raw/*34.1*/("""</div>

<script src=""""),_display_(/*36.15*/routes/*36.21*/.Assets.versioned("javascripts/search.js")),format.raw/*36.63*/(""""></script>
<footer class="footer">
    <p>&copy; 2023 Martian. All rights reserved.</p>
</footer>

</body>
</html>

"""))
      }
    }
  }

  def render(symbolList:Seq[scala.Tuple3[String, String, String]],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(symbolList)(request,flash)

  def f:((Seq[scala.Tuple3[String, String, String]]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (symbolList) => (request,flash) => apply(symbolList)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/search.scala.html
                  HASH: 0b373d8954ac4b2900ccb2408f52eb41af88d9c4
                  MATRIX: 793->1|985->100|1012->101|1392->455|1424->478|1464->480|1496->485|1537->499|1594->540|1634->542|1670->551|1734->588|1761->594|1815->621|1842->627|1896->654|1921->658|1977->687|2004->693|2063->721|2095->726|2124->738|2137->742|2176->743|2208->748|2275->785|2303->786|2352->808|2367->814|2430->856
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|50->26|50->26|51->27|51->27|53->29|54->30|55->31|55->31|55->31|56->32|57->33|58->34|60->36|60->36|60->36
                  -- GENERATED --
              */
          