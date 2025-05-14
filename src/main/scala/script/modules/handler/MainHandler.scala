package sbt.megallink
package script.modules.handler

import com.google.inject.Inject
import org.apache.log4j.Logger
import sbt.megallink.script.modules.files.services.FileManagerService
import net.liftweb.json.{DefaultFormats, parse}
import net.liftweb.util.StringHelpers.camelifyMethod
import sbt.megallink.script.modules.files.implementations.models.Person
import sbt.megallink.script.modules.spark.implementations.MySparkManager
class MainHandler @Inject()(
                           logger:Logger,
                           fileManager:FileManagerService,
                           sparkManager:MySparkManager
                           ) {
  def run():Unit={
    val heroesFromCSV=fileManager.getHeroesFromCSVFile("src/main/resources/heroes.csv")
    val heroesFromExcel=fileManager.getHeroesFromExcelFile("src/main/resources/Heroes.xlsx")
    logger.info(s"Heroes from CSV:${heroesFromCSV.length}")
    heroesFromCSV.foreach(hero=>logger.info(hero))
    logger.info(s"Heroes from Excel:${heroesFromExcel.length}")
    heroesFromExcel.foreach(hero=>logger.info(hero))
    testLift()
    sparkManager.testRdd()
  }

  def testLift(): Unit ={
    implicit val formats = DefaultFormats
    val jsonValue =
      """
        |{
        |	"name_value": "Jeff",
        |	"detail_value": {
        |		"age": 10,
        |	}
        |}
        |""".stripMargin

    val convertedString=camelifyMethod(jsonValue)
    logger.info(s"json camelify:${convertedString}")
    val json = parse(convertedString)
    val person = json.extract[Person]
    logger.info(s"Person with option:${person}")
    logger.info(s"Person with option alias:${person.detailValue.alias.getOrElse("not found")}")
  }
}
