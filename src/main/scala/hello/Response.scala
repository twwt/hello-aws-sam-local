package hello

import scala.beans.BeanProperty
import scala.collection.JavaConverters

case class Response(@BeanProperty body: String, @BeanProperty headers: java.util.Map[String, String], @BeanProperty statusCode: Int)

object Response {
  private val contentJson = "Content-Type" -> "application/json"

  def apply(body: String, headers: Map[String, String] = Map(contentJson), statusCode: Int = 200) = {
    new Response(body, JavaConverters.mapAsJavaMap[String, String](Map("Content-Type" -> "application/json")), statusCode)
  }
}