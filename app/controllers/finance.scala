package controllers

import javax.inject._
import play.api.mvc.{MessagesAbstractController, _}
import Models.TaskListInDatabaseModel
import org.h2.jdbc.JdbcDatabaseMetaData
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{Await, ExecutionContext, Future}
import Models.Tables.UsersRow
import akka.actor.ActorSystem
import akka.stream.Materializer
import play.api.libs.streams.ActorFlow
import actors.ChatActor
import akka.actor.Props
import actors.ChatManager
import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.JsObject.writes
import play.api.libs.json.OFormat.oFormatFromReadsAndOWrites
import play.api.libs.json.{Format, JsValue, Json, Writes}

import java.sql.Timestamp
import javax.inject._
import play.api.libs.json._



case class StockDetails(symbol: String, open: Double, high: Double, low:Double, close:Double, volume:Double)

object StockDetails {
  implicit val stockDetailsFormat: Format[StockDetails] = Json.format[StockDetails]
}

@Singleton
class finance @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                        cc: MessagesControllerComponents
                       ,polygonApiClient: PolygonApiClient)
                       (implicit assetsFinder: AssetsFinder,
                        ec: ExecutionContext,
                        system: ActorSystem,
                        mat:Materializer)
extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile]{

  def home = Action.async { implicit request =>
    val symbol = "AAPL"
    searchTicker()
    polygonApiClient.getStockPrice(symbol).map { stockPrice =>
      println(stockPrice)
      Ok(views.html.home())
    }
  }

  def searchTicker = Action.async { implicit request =>
    println("Start")
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val stockSymbolOption = args.get("symbol").flatMap(_.headOption)
      stockSymbolOption.map { symbol =>
        polygonApiClient.getTicker(symbol).map { searchList =>
          Ok(views.html.search(searchList))
        }
      }.getOrElse (Future.successful(BadRequest("Please provide a valid stock symbol")))
    }.getOrElse (Future.successful(BadRequest("Invalid form data")))
  }


  def stockDetails: Action[AnyContent] = Action.async { implicit request =>
    val symbolResult = request.body.asJson.flatMap(json => (json \ "symbol").asOpt[String])
    symbolResult match {
      case Some(symbol) =>
        println(symbol)
        polygonApiClient.getStockDetails(symbol).map {
          case Some(stockDetails) =>
            Ok(Json.toJson(stockDetails))
          case None =>
            BadRequest("Stock details not found for the given symbol.")
        }.recover {
          case ex: Exception =>
            BadRequest(s"Error fetching stock details: ${ex.getMessage}")
        }
      case None =>
        Future.successful(BadRequest("Missing 'symbol' parameter in the request body"))
    }
  }







  def getStockPrice(symbol: String): Action[AnyContent] = Action {
    // Implement the logic to get the stock price for a given symbol
    // You can use the 'counter' service for testing purposes, replace it with actual logic

    // For testing purposes, let's assume a stock price of 100.0 for symbol ABC
    val stockPrice = 100.0
    Ok(s"Stock price for symbol $symbol: $stockPrice")
  }

  def getPortfolioData() = TODO

  def getFinancialNews() = TODO
}
