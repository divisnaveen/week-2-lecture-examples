package com.example.coalmine

import akka.actor.{Actor, ActorLogging, Props}
import akka.actor.Actor.Receive
import com.example.coalmine.AmoralMineCeo.FoundMiningCompany

/**
  * NOTE We can make the entry point of our application into an Actor in the
  * following way: we extend Actor, but then use akka.Main as the entry point
  * of our application, and give as command line arguments the fully qualified
  * class name of the actor we want to create immediately upon start up (in
  * this case that's com.example.coalmine.CrookedCoalMineMain).
  */
class CrookedCoalMineMain extends Actor with ActorLogging {

  // NOTE From the starting/enclosing/launching actor that we're in, we'll
  // create the actor that serves as the top of the tree of actors that makes
  // up our application...
  val ceo = context.actorOf(AmoralMineCeo.props, "Amoral-Mine-CEO")

  log.info("Starting up CrookedCoalMine...")

  // NOTE Now we tell the CEO actor to get started doing its glorious work...
  ceo ! FoundMiningCompany      // Tell terrible CEO to start the company

  // NOTE This outer enclosing actor really doesn't do anything with messages
  // it receives...
  override def receive: Receive = {
    case _ =>
  }
}
