package tech.navicore.lotsofnames.api.routes

import java.util.Date

import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import akka.http.scaladsl.server.{Directives, Route}
import com.typesafe.scalalogging.LazyLogging
import tech.navicore.lotsofnames.api.ErrorSupport
import tech.navicore.lotsofnames.api.models._
import spray.json._
import tech.navicore.lotsofnames.LotsOfPeople

object NamesSegmentRoute
    extends JsonSupport
    with LazyLogging
    with Directives
    with ErrorSupport {

  def apply: Route =
    path(urlpath / Segment) { sourceId =>
      logRequest(s"$urlpath / $sourceId") {
        handleErrors {
          cors(corsSettings) {
            get {
              val response = Name(java.util.UUID.randomUUID(),
                                  new Date(),
                                  sourceId,
                                  LotsOfPeople(sourceId))
              complete(response.toJson.prettyPrint)
            }
          }
        }
      }
    }
}
