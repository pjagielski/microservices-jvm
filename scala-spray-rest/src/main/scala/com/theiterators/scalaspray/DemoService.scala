package com.theiterators.scalaspray

import spray.routing._
import spray.http._
import MediaTypes._

trait DemoService extends HttpService {
  val myRoute =
    path("messages" / RestPath) { name =>
        get {
          respondWithMediaType(`text/html`) {
            complete {
              s"Hello World $name"
            }
          }
        }
    }
}