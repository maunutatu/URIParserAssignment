import Classes._

// Client for testing RequestIdentifier

object RequestClient extends App {

  // App waits for user input
  val identifiedRequest = new RequestIdentifier(scala.io.StdIn.readLine())

  // If the given URI is invalid, user is notified. If not, path and parameters are listed for the user.
  if (identifiedRequest.getPath == "invalid request") {
    println("Invalid Request. Please check the syntax of the given URI")
  } else {
    println("Successful request\nInformation:")
    println(s"Path: ${identifiedRequest.getPath}")
    println(s"Parameters:")
    identifiedRequest.getParameter.foreach(x => println(s"${x._1} = ${x._2}"))
  }
}
