import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerTest

/**
 * Runs a browser test using Fluentium against a play application on a server port.
 */
class BrowserSpec extends PlaySpec
  with OneBrowserPerTest
  with GuiceOneServerPerTest
  with HtmlUnitFactory
  with ServerProvider {

  "Application" should {

    "work from within a browser" in {

      go to ("http://localhost:" + port + "/login")

      pageSource must include ("MARTIAN")
    }
  }
}
