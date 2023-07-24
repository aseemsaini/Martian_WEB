package Models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://dumbo.db.elephantsql.com:5432/clbjlxjl?user=clbjlxjl&password=AsX-7qmnvcya5K3qeRw366srfKawSz8Q",
    "/Users/aseemsaini/Desktop/ACM/Martian_WEB/app/",
    "Models", None, None, true, false
  )
}
