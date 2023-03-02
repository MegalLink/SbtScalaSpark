package sbt.megallink
package script.modules.files.providers

import org.apache.spark.sql.{DataFrame, SparkSession}

import javax.inject.Inject


class CSVReader @Inject()(sparkSession: SparkSession) {
    def read(filePath:String,separator: String=","): DataFrame = {
     sparkSession
       .read
       .options(
         Map(
           "header"->"true",
           "delimiter"->separator
         )
       )
       .csv(filePath)
    }
}
