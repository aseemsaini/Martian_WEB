import akka.stream.Materializer
import controllers.finance1
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._

class FinanceSpec extends PlaySpec with GuiceOneAppPerSuite {

  implicit lazy val mat: Materializer = app.materializer

  // You can now directly access the finance1 controller from the app instance
  val controller = app.injector.instanceOf[finance1]

  "Finance" should {

    "return the stock price for a given symbol" in {
      val fakeRequest = FakeRequest(GET, "/home") // Use /home instead of /stocks/ABC
      val result = call(controller.getStockPrice("ABC"), fakeRequest)
      status(result) mustBe Status.OK
      contentAsString(result) must include("Stock price for symbol ABC")
    }

    "return the portfolio tracking data for a user" in {
      val fakeRequest = FakeRequest(GET, "/portfolio")
      val result = call(controller.getPortfolioData(), fakeRequest)
      status(result) mustBe Status.OK
      contentAsString(result) must include("Portfolio data")
    }

    "return the latest financial news" in {
      val fakeRequest = FakeRequest(GET, "/news")
      val result = call(controller.getFinancialNews(), fakeRequest)
      status(result) mustBe Status.OK
      contentAsString(result) must include("Financial news")
    }

    "return an error message for an invalid stock symbol in searchTicker" in {
      val fakeRequest = FakeRequest(POST, "/search").withFormUrlEncodedBody("symbol" -> "INVALID_SYMBOL")
      val result = call(controller.searchTicker, fakeRequest)
      status(result) mustBe Status.OK
      contentAsString(result) must include("No search results found.")
    }

    "return an error message for missing form data in searchTicker" in {
      val fakeRequest = FakeRequest(POST, "/search")
      val result = call(controller.searchTicker, fakeRequest)
      status(result) mustBe Status.BAD_REQUEST
      contentAsString(result) must include("Invalid form data")
    }

    // Add more test cases for other functionalities of the finance controller as per your app's requirements

  }
}
