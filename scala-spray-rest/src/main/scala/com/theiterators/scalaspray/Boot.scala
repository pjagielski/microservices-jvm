package com.theiterators.scalaspray

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import com.typesafe.config.ConfigFactory

object Boot extends App {
  val config = ConfigFactory.load()

  implicit val system = ActorSystem("on-spray-can")

  val service = system.actorOf(Props[DemoServiceActor], "demo-service")

  IO(Http) ! Http.Bind(service, interface = config.getString("host.interface"), port = config.getInt("host.port"))
}