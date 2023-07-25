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
import java.sql.Timestamp
import javax.inject._

@Singleton
class finance @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents
                       ,polygonApiClient: PolygonApiClient)(implicit assetsFinder: AssetsFinder, ec: ExecutionContext, system: ActorSystem, mat:Materializer)
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
    val symbol = "Apple"
    println("Start")
    polygonApiClient.getTicker(symbol).map { search =>
      println(search)
      Ok(views.html.home())
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
