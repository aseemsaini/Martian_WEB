
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

object test extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
    <input type ="hidden" id = "ws-route" value = """"),_display_(/*4.53*/routes/*4.59*/.authentication.socket.absoluteURL()),format.raw/*4.95*/("""">
    <input type ="text" id = "test-input" size = "80">
    <br>
    <textarea id = "test-area" size = "80" rows="15"></textarea>
    <script src=""""),_display_(/*8.19*/routes/*8.25*/.Assets.versioned("javascripts/test.js")),format.raw/*8.65*/(""""></script>
</html>"""))
      }
    }
  }

  def render(request:RequestHeader,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply()(request,assetsFinder)

  def f:(() => (RequestHeader,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = () => (request,assetsFinder) => apply()(request,assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/test.scala.html
                  HASH: 229f18b2308d60a191989cfb30cf0123e4067930
                  MATRIX: 748->1|905->65|932->66|1017->125|1031->131|1087->167|1263->317|1277->323|1337->363
                  LINES: 21->1|26->2|27->3|28->4|28->4|28->4|32->8|32->8|32->8
                  -- GENERATED --
              */
          