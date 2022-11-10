package sbt.megallink

import com.google.inject.{Guice, Injector, Module, Stage => InjectStage}
import script.InjectorCreator

import net.codingwell.scalaguice.InjectorExtensions._
import script.modules.handler.MainHandler

import org.apache.log4j.Logger

class BaseScript{
  var injector : Injector =_

  def setInjector(newInjector: Injector):Unit ={
    injector = newInjector
  }

  def main( args:Array[String]):Unit={
    if (injector == null){
      setInjector(new InjectorCreator().build())
    }
    val logger :Logger= injector.instance[Logger]
    logger.info("Started.....")
    injector.instance[MainHandler].run()
    logger.info("Finished.....")
  }
}
