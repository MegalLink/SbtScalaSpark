package sbt.megallink
package script.modules.files.providers

import org.apache.spark.sql.{DataFrame, SparkSession}
import script.modules.files.models.{Hero, HeroFields}

import org.apache.log4j.Logger

import javax.inject.Inject

class DataFrameMapper@Inject()(sparkSession: SparkSession,logger: Logger){
    def mapDataframeToHero(dataframe:DataFrame,filter:String=""):List[Hero] = {
      val viewName="heroes"
      dataframe.createOrReplaceTempView(viewName)
      val renamedDf = sparkSession.sql(heroesSql(viewName,filter))
      import sparkSession.implicits._

      val heroes:List[Hero] = renamedDf.as[Hero].collect().toList
      logger.info(s"total heroes obtained from file: ${heroes.length}")
      heroes
    }

  private def heroesSql(viewName:String,filter:String): String = {
      s"""
       |SELECT
       |cast(${HeroFields.age} as int) as age,
       |${HeroFields.alias} as alias,
       |${HeroFields.name} as name
       |FROM
       |  $viewName
       |$filter
       |""".stripMargin
  }
}
