package tech.navicore.lotsofnames.api.routes

import java.util.Date

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import com.typesafe.scalalogging.LazyLogging
import spray.json._
import tech.navicore.lotsofnames.LotsOfPeople
import tech.navicore.lotsofnames.api.HttpSupport
import tech.navicore.lotsofnames.api.models.{Name, _}

object NamesSegmentRoute
    extends JsonSupport
    with LazyLogging
    with Directives
    with HttpSupport {

  def apply: Route = {
    path(urlpath / Segment) { sourceId =>
      logRequest(s"$urlpath / $sourceId") {
        handleErrors {
          cors(corsSettings) {
            get {
              val response = Name(java.util.UUID.randomUUID(),
                                  new Date(),
                                  sourceId,
                                  LotsOfPeople(sourceId))
              complete(
                HttpEntity(ContentTypes.`application/json`,
                           response.toJson.prettyPrint))
            }
          }
        }
      }
    }
  }
}
