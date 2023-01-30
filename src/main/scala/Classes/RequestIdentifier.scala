package Classes

import java.net.URISyntaxException

// RequestIdentifier is responsible for parsing the given URI and returning the correct path and parameters for said URI

class RequestIdentifier(uri: String) {

  // URI is parsed with Java Class java.net.URI. Try/catch expression is used in case of an invalid URI.

  private[this] val uriParser : java.net.URI = try {
    new java.net.URI(uri.trim)
  } catch {
    case e: URISyntaxException => new java.net.URI("")
  }

  // visma-identity scheme is enforced. If it's correct, the path is fetched. If not, path is saved as an "invalid request"

  private[this] val path: String = if(uriParser.getScheme == "visma-identity") {
    uriParser.getAuthority
  } else {
    "invalid request"
  }

  // Helper function for fetching a wanted parameter from the URI and returning it as a String
  private[this] def getParameterFromQuery(parameterName: String): String = {
    val query = uriParser.getQuery

    /* Query's parameters are split into an array of different parameters.
       The wanted parameter is filtered from the array of different parameters
     */
    val sourceFromQuery: String = query.split("&").filter(_.contains(parameterName + "=")).head

    // Parameter value is separated from the string and returned
    sourceFromQuery.split(parameterName + "=")(1)
  }

  /* Parameters are different for each path so match case expression is used to look for the parameters of the corresponding path

     Confirm request's payment number is to be returned as an integer, therefore transformed to an integer with toInt.
     A try/catch expression is used to avoid errors in case of an invalid parameter.
   */
  private[this] val parameters: Map[String, Any] = path match {
    case "login" => Map("source" -> getParameterFromQuery("source"))
    case "sign" => Map("source" -> getParameterFromQuery("source"), "documentid" -> getParameterFromQuery("documentid"))
    case "confirm" => try {
      Map("source" -> getParameterFromQuery("source"), "paymentnumber" -> getParameterFromQuery("paymentnumber").toInt)
    } catch {
      case e: NumberFormatException => Map()
    }
    case _ => Map()
  }

  // Path value is returned with a public method
  def getPath: String = path

  // Parameter is returned with a public method
  def getParameter: Map[String, Any] = parameters
}
