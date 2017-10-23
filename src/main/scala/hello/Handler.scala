package hello


import com.amazonaws.services.lambda.runtime._
import scala.collection.JavaConverters
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent

class Handler extends RequestHandler[APIGatewayProxyRequestEvent, Response] {

  def handleRequest(input: APIGatewayProxyRequestEvent, context: Context): Response = {
    input.getHttpMethod match {
      case "GET" => response(s"""{ \"Output!\" : \"receive get request\"}""", 200)
      case "POST" => response(s"""{ \"Output!\" : \"receive post request\"}""", 200)
      case _ => response("""{ \"error\" : \"http method is invalid.\"}""", 500)
    }
  }

  def response(messageJson: String, statusCode: Int): Response = {
    Response(messageJson, JavaConverters.mapAsJavaMap[String, String](Map("Content-Type" -> "application/json")), statusCode)
  }

}
