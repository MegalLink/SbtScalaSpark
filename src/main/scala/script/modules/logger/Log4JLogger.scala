package sbt.megallink
package script.modules.logger

import org.apache.log4j.{Level, Logger}

object Log4JLogger {
  Logger.getRootLogger.setLevel(Level.INFO)
  val logger:Logger = Logger.getLogger("|==>")
}