import akka.stream.Materializer
import controllers.finance
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._

class FinanceSpec extends PlaySpec with GuiceOneAppPerSuite {

  implicit lazy val mat: Materializer = app.materializer

  "Finance" should {

    "return the stock price for a given symbol" in {
      // Create an instance of the Finance controller
      val controller = new finance(stubControllerComponents())

      // Call the 'getStockPrice' action method with a FakeRequest
      val fakeRequest = FakeRequest(GET, "/stocks/ABC")
      val result = call(controller.getStockPrice("ABC"), fakeRequest)

      // Assert that the response status is OK (200)
      status(result) mustBe Status.OK

      // Assert that the content of the response contains the stock price information
      contentAsString(result) must include("Stock price for symbol ABC")
    }

    "return the portfolio tracking data for a user" in {
      // Create an instance of the Finance controller
      val controller = new finance(stubControllerComponents())

      // Call the 'getPortfolioData' action method with a FakeRequest
      val fakeRequest = FakeRequest(GET, "/portfolio")
      val result = call(controller.getPortfolioData(), fakeRequest)

      // Assert that the response status is OK (200)
      status(result) mustBe Status.OK

      // Assert that the content of the response contains the portfolio tracking data
      // You can customize this test based on the expected data format in the response
      contentAsString(result) must include("Portfolio data")
    }

    "return the latest financial news" in {
      // Create an instance of the Finance controller
      val controller = new finance(stubControllerComponents())

      // Call the 'getFinancialNews' action method with a FakeRequest
      val fakeRequest = FakeRequest(GET, "/news")
      val result = call(controller.getFinancialNews(), fakeRequest)

      // Assert that the response status is OK (200)
      status(result) mustBe Status.OK

      // Assert that the content of the response contains the financial news
      // You can customize this test based on the expected data format in the response
      contentAsString(result) must include("Financial news")
    }

    // Add more test cases for other functionalities of the finance controller as per your app's requirements

  }
}
