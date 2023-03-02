package sbt.megallink
package script.modules.files.providers

import org.apache.spark.sql.{DataFrame, SparkSession}
import sbt.megallink.script.modules.files.implementations.models.{Hero, HeroFields}
import javax.inject.Inject

class DataFrameMapper@Inject()(sparkSession: SparkSession){
    def mapDataframeToHero(dataframe:DataFrame,filter:String=""):List[Hero] = {
      val viewName="heroes"
      dataframe.createOrReplaceTempView(viewName)
      val renamedDf = sparkSession.sql(heroesSql(viewName,filter))
      import sparkSession.implicits._
      val heroes:List[Hero] = renamedDf.as[Hero].collect().toList
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
