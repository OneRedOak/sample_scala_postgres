package com.shippable

import com.github.mauricio.async.db.postgresql.PostgreSQLConnection
import com.github.mauricio.async.db.postgresql.util.URLParser
import com.github.mauricio.async.db.util.ExecutorServiceUtils.CachedExecutionContext
import com.github.mauricio.async.db.{RowData, QueryResult, Connection}
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class HelloWorld {
   def returnValue(): String= {

   val configuration = URLParser.parse("jdbc:postgresql://localhost:5233/test?user=postgres")
   val connection: Connection = new PostgreSQLConnection(configuration)
   var finalResult = ""

   Await.result(connection.connect, 5 seconds)

   val future: Future[QueryResult] = connection.sendQuery("SELECT * FROM users WHERE username='lindsaybluth';")

   val mapResult: Future[Any] = future.map(queryResult => queryResult.rows match {
      case Some(resultSet) => {
         val row : RowData = resultSet.head
         finalResult = row(2).toString
      }
      case None => -1
   }
   )
   val result = Await.result( mapResult, 5 seconds )
   connection.disconnect
   return finalResult
   }
}