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

  case class StockDetails(symbol: String, open: Double, high: Double, low:Double, close:Double, volume:Double)

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
    val currentDate = LocalDate.now()
    val yesterday = currentDate.minusDays(1)
    val url = s"$baseUrl/v1/open-close/$symbol/$yesterday?adjusted=true&apiKey=$apiKey"
    ws.url(url).get().map{ response =>
      println(response)
      response.status match {
        case 200 => {
          val open = (response.json \ "open").asOpt[Double].getOrElse(0.0)
          val high = (response.json \ "high").asOpt[Double].getOrElse(0.0)
          val low = (response.json \ "low").asOpt[Double].getOrElse(0.0)
          val close = (response.json \ "close").asOpt[Double].getOrElse(0.0)
          val volume = (response.json \ "volume").asOpt[Double].getOrElse(0.0)
          Some(StockDetails(symbol, open, high, low, close, volume))
        }
      }
    }
  }




}
