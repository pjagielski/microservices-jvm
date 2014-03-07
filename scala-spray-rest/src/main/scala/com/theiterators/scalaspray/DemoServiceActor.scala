package com.theiterators.scalaspray

import akka.actor.Actor

class DemoServiceActor extends Actor with DemoService {
   def actorRefFactory = context

   def receive = runRoute(myRoute)
 }
