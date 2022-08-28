package tech.navicore.lotsofnames.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.LazyLogging
import tech.navicore.lotsofnames.api.models._
import tech.navicore.lotsofnames.api.routes.{NamesRoute, NamesSegmentRoute}
import scala.concurrent.ExecutionContextExecutor

object Main extends LazyLogging with JsonSupport with HttpSupport {

  def main(args: Array[String]) {

    implicit val system: ActorSystem = ActorSystem("LotsOfNamesApi-system")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val route =
      HealthCheck ~
        NamesRoute.apply ~
        NamesSegmentRoute.apply

    Http().newServerAt("0.0.0.0", port).bindFlow(route)
  }
}
