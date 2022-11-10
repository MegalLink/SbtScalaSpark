package sbt.megallink
package script.modules.handler

import com.google.inject.Inject
import org.apache.log4j.Logger
import sbt.megallink.script.modules.files.services.FileManagerService

class MainHandler @Inject()(
                           logger:Logger,
                           fileManager:FileManagerService
                           ) {
  def run():Unit={
    val heroes=fileManager.getHeroesFromFile("src/main/resources/heroes.csv")
    logger.info(s"first hero: ${heroes(0)}")
  }
}
