import controllers.routes
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.mvc.ControllerHelpers.request2flash
import play.api.mvc.MessagesRequestHeader
import views.html.search
class HTMLSpec extends PlaySpec with GuiceOneAppPerSuite {

  "Home Template" should {

    "include the heading, form fields, and a button" in { implicit request: MessagesRequestHeader =>
      val htmlContent = views.html.home().toString
      val doc: Document = Jsoup.parse(htmlContent)

      // Check if the heading is present
      val heading = doc.getElementsByTag("h1").first()
      heading must not be null
      heading.text mustBe "Welcome To Martian"

      // Check if the form field is present
      val formField = doc.getElementById("symbol")
      formField must not be null

      // Check if the button is present
      val button = doc.getElementsByTag("button").first()
      button must not be null
      button.attr("type") mustBe "submit"
      button.text mustBe "Search"
    }

    "include the correct form action" in { implicit request: MessagesRequestHeader =>
      val htmlContent = views.html.home().toString
      val doc: Document = Jsoup.parse(htmlContent)

      // Check if the form action is correctly set
      val form = doc.getElementsByTag("form").first()
      form must not be null
      form.attr("action") mustBe routes.finance.searchTicker.toString
    }

    "include the CSRF form field" in { implicit request: MessagesRequestHeader =>
      val htmlContent = views.html.home().toString
      val doc: Document = Jsoup.parse(htmlContent)

      // Check if the CSRF form field is included
      val csrfField = doc.getElementById("csrfToken")
      csrfField must not be null
    }
  }

  "Search Template" should {

    "include the list structure" in { implicit request: MessagesRequestHeader =>
      val symbolList = Seq.empty
      val htmlContent = search(symbolList).toString
      val doc = Jsoup.parse(htmlContent)
      val container = doc.getElementsByClass("container").first()
      container must not be null
      val unorderedList = container.getElementsByTag("ul").first()
      unorderedList must not be null
    }

    "include the 'No search results found' message when the list is empty" in {
      implicit request: MessagesRequestHeader =>
      val symbolList = Seq.empty
      val htmlContent = search(symbolList).toString
      val doc = Jsoup.parse(htmlContent)
      val noResultsElement = doc.select("p:contains(No search results found)").first()
      noResultsElement must not be null
    }
  }

}
