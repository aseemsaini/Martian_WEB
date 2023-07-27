package controllers

import play.api.libs.json.{JsValue, Json, Reads, Writes}

import javax.inject._
import play.api.libs.ws._
import play.api.libs.json.JsValue._
import play.api.mvc.ControllerHelpers.TODO

import java.time.LocalDate
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PolygonApiClient @Inject()(ws: WSClient)(implicit ec: ExecutionContext) {

  private val baseUrl = "https://api.polygon.io"
  private val apiKey = "ZZNkOA0d9h77o_OMJqepnHomUbI1TD47"
  private val api_alpha = "Y7BV9OVUZZ7JSTTA"

  case class StockDetails(symbol: String, last_refreshed:String, open: Double, high: Double, low:Double, close:Double, volume:Double)

  object StockDetails {
    implicit val stockDetailsReads: Reads[StockDetails] = Json.reads[StockDetails]
    implicit val stockDetailsWrites: Writes[StockDetails] = Json.writes[StockDetails]
  }


  def getStockPrice(symbol: String): Future[Double] = {
    val url = s"$baseUrl/v2/aggs/ticker/$symbol/prev?adjusted=true&apiKey=$apiKey"
    ws.url(url).get().map { response =>
      println(response)
      response.status match {
        case 200 => {
          val stockPrice = (response.json \ "results" \ 0 \ "c").asOpt[Double].getOrElse(0.0)
          println(s"Previous stock price: $stockPrice")
          stockPrice
        }
        case _ => 0.0
      }
    }
  }

  def getTicker(symbol: String): Future[Seq[(String, String, String)]] = {
    val url = s"https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=$symbol&apikey=$api_alpha"
    ws.url(url).get().map { response =>
      println(response)
      response.status match {
        case 200 => {
          val searchResults = (response.json \ "bestMatches").as[Seq[JsValue]].flatMap { jsValue =>
            for {
              symbol <- (jsValue \ "1. symbol").asOpt[String]
              name <- (jsValue \ "2. name").asOpt[String]
              region <- (jsValue \ "4. region").asOpt[String]
            } yield (symbol, name, region)
          }
          println(s"Search: $searchResults")
          searchResults
        }
        case _ => Seq.empty[(String, String, String)]
      }
    }
  }

  def getStockDetails(symbol:String):Future[Option[StockDetails]] = {
    val url = s"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=$symbol&apikey=$api_alpha"
    ws.url(url).get().map{ response =>
      println(response)
      response.status match {
        case 200 => {
          val date = (response.json \ "Meta Data" \ "3. Last Refreshed").as[String]
          println(date)
          val timeSeriesData = (response.json \ "Time Series (Daily)").as[Map[String, Map[String, String]]]
          timeSeriesData.get(date).map { data =>
              println("STARTTTTTTTTTTTTTTTTT")
              val open = data("1. open").toDouble
              val high = data("2. high").toDouble
              val low = data("3. low").toDouble
              val close = data("4. close").toDouble
              val volume = data("5. volume").toDouble
              println("OPENNNNNNNN")
              println(open)
              Some(StockDetails(symbol, date, open, high, low, close, volume))
          }.getOrElse(None)
        }
        case _ => None // Error occurred while fetching data
      }
    }
  }




}
