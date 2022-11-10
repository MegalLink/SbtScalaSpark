package sbt.megallink
package script.modules.files.providers

import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SparkSession}

import javax.inject.Inject


class CSVReader @Inject()(sparkSession: SparkSession) {
    def read(filePath:String,separator: String=","): DataFrame = {
     sparkSession
       .read
       .format("csv")
       .options(
         Map(
           "header"->"true",
           "delimiter"->separator
         )
       )
       .load(filePath)
    }
  // all options https://github.com/databricks/spark-csv#features
}
