package com.theiterators.scalaspray

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class DemoServiceSpec extends Specification with Specs2RouteTest with DemoService {
  def actorRefFactory = system

  "DemoService" should {
    "return a message for GET requests to the messages path" in {
      Get("/messages/John") ~> myRoute ~> check {
        status === OK
        responseAs[String] must contain("Hello World John")
      }
    }

    "return 404 for other routes" in {
      Get("/bogus") ~> myRoute ~> check {
        handled must beFalse
      }
    }
  }
}