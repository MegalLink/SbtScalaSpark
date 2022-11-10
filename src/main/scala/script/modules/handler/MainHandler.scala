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
    val heroesFromCSV=fileManager.getHeroesFromCSVFile("src/main/resources/heroes.csv")
    val heroesFromExcel=fileManager.getHeroesFromExcelFile("src/main/resources/Heroes.xlsx")
    logger.info("Heroes from CSV")
    heroesFromCSV.foreach(hero=>logger.info(hero))
    logger.info("Heroes from Excel")
    heroesFromExcel.foreach(hero=>logger.info(hero))
  }
}
