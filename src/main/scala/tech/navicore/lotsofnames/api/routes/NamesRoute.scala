package tech.navicore.lotsofnames.api.routes

import java.util.Date

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import com.typesafe.scalalogging.LazyLogging
import tech.navicore.lotsofnames.api.ErrorSupport
import tech.navicore.lotsofnames.api.models._
import spray.json._
import tech.navicore.lotsofnames.LotsOfPeople

object NamesRoute
    extends JsonSupport
    with LazyLogging
    with Directives
    with ErrorSupport {

  def apply: Route =
    path(urlpath) {
      logRequest(urlpath) {
        handleErrors {
          cors(corsSettings) {
            get {
              logger.debug(s"get $urlpath")
              complete(
                HttpEntity(ContentTypes.`application/json`,
                           "{\"msg\": \"Say hello to Lots of Names API\"}\n"))
            } ~
              post {
                decodeRequest {
                  entity(as[Query]) { m =>
                    val response = Name(java.util.UUID.randomUUID(),
                                        new Date(),
                                        m.sourceId,
                                        LotsOfPeople(m.sourceId))
                    complete(response.toJson.prettyPrint)
                  }
                }
              }

          }
        }
      }
    }
}
