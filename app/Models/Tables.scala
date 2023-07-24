package Models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile = slick.jdbc.PostgresProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Portfolio.schema ++ Users.schema ++ Watchlist.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Portfolio
   *  @param portfolioId Database column portfolio_id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param symbol Database column symbol SqlType(varchar), Length(10,true)
   *  @param quantity Database column quantity SqlType(int4)
   *  @param averagePrice Database column average_price SqlType(numeric) */
  case class PortfolioRow(portfolioId: Int, userId: Int, symbol: String, quantity: Int, averagePrice: scala.math.BigDecimal)
  /** GetResult implicit for fetching PortfolioRow objects using plain SQL queries */
  implicit def GetResultPortfolioRow(implicit e0: GR[Int], e1: GR[String], e2: GR[scala.math.BigDecimal]): GR[PortfolioRow] = GR{
    prs => import prs._
    PortfolioRow.tupled((<<[Int], <<[Int], <<[String], <<[Int], <<[scala.math.BigDecimal]))
  }
  /** Table description of table portfolio. Objects of this class serve as prototypes for rows in queries. */
  class Portfolio(_tableTag: Tag) extends profile.api.Table[PortfolioRow](_tableTag, "portfolio") {
    def * = (portfolioId, userId, symbol, quantity, averagePrice) <> (PortfolioRow.tupled, PortfolioRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(portfolioId), Rep.Some(userId), Rep.Some(symbol), Rep.Some(quantity), Rep.Some(averagePrice))).shaped.<>({r=>import r._; _1.map(_=> PortfolioRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column portfolio_id SqlType(serial), AutoInc, PrimaryKey */
    val portfolioId: Rep[Int] = column[Int]("portfolio_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column symbol SqlType(varchar), Length(10,true) */
    val symbol: Rep[String] = column[String]("symbol", O.Length(10,varying=true))
    /** Database column quantity SqlType(int4) */
    val quantity: Rep[Int] = column[Int]("quantity")
    /** Database column average_price SqlType(numeric) */
    val averagePrice: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("average_price")

    /** Foreign key referencing Users (database name portfolio_user_id_fkey) */
    lazy val usersFk = foreignKey("portfolio_user_id_fkey", userId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Portfolio */
  lazy val Portfolio = new TableQuery(tag => new Portfolio(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(varchar), Length(50,true)
   *  @param password Database column password SqlType(varchar), Length(200,true)
   *  @param email Database column email SqlType(varchar), Length(100,true)
   *  @param balance Database column balance SqlType(numeric), Default(10000.00) */
  case class UsersRow(id: Int, username: String, password: String, email: String, balance: scala.math.BigDecimal = scala.math.BigDecimal("10000.00"))
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[scala.math.BigDecimal]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[scala.math.BigDecimal]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, "users") {
    def * = (id, username, password, email, balance) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(username), Rep.Some(password), Rep.Some(email), Rep.Some(balance))).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(varchar), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    /** Database column password SqlType(varchar), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
    /** Database column email SqlType(varchar), Length(100,true) */
    val email: Rep[String] = column[String]("email", O.Length(100,varying=true))
    /** Database column balance SqlType(numeric), Default(10000.00) */
    val balance: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("balance", O.Default(scala.math.BigDecimal("10000.00")))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))

  /** Entity class storing rows of table Watchlist
   *  @param watchlistId Database column watchlist_id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param name Database column name SqlType(varchar), Length(100,true)
   *  @param symbol Database column symbol SqlType(varchar), Length(500,true)
   *  @param createdAt Database column created_at SqlType(timestamp) */
  case class WatchlistRow(watchlistId: Int, userId: Int, name: String, symbol: String, createdAt: java.sql.Timestamp)
  /** GetResult implicit for fetching WatchlistRow objects using plain SQL queries */
  implicit def GetResultWatchlistRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[WatchlistRow] = GR{
    prs => import prs._
    WatchlistRow.tupled((<<[Int], <<[Int], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table watchlist. Objects of this class serve as prototypes for rows in queries. */
  class Watchlist(_tableTag: Tag) extends profile.api.Table[WatchlistRow](_tableTag, "watchlist") {
    def * = (watchlistId, userId, name, symbol, createdAt) <> (WatchlistRow.tupled, WatchlistRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(watchlistId), Rep.Some(userId), Rep.Some(name), Rep.Some(symbol), Rep.Some(createdAt))).shaped.<>({r=>import r._; _1.map(_=> WatchlistRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column watchlist_id SqlType(serial), AutoInc, PrimaryKey */
    val watchlistId: Rep[Int] = column[Int]("watchlist_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column symbol SqlType(varchar), Length(500,true) */
    val symbol: Rep[String] = column[String]("symbol", O.Length(500,varying=true))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")

    /** Foreign key referencing Users (database name watchlist_user_id_fkey) */
    lazy val usersFk = foreignKey("watchlist_user_id_fkey", userId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Watchlist */
  lazy val Watchlist = new TableQuery(tag => new Watchlist(tag))
}
