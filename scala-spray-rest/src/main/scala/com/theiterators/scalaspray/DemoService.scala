package com.theiterators.scalaspray

import spray.json._
import DefaultJsonProtocol._
import spray.routing._
import spray.http._
import MediaTypes._
import spray.httpx.SprayJsonSupport

case class Message(message: String)

object DemoJsonProtocol extends DefaultJsonProtocol {
  implicit val messageFormat = jsonFormat1(Message)
}

import DemoJsonProtocol._

trait DemoService extends HttpService {
  val myRoute =
    path("messages" / spray.routing.PathMatchers.Segment) { name =>
        get {
          respondWithMediaType(`application/json`) {
            complete {
              CompactPrinter(Message(s"Hello World ${name}").toJson)
            }
          }
        }
    }
}