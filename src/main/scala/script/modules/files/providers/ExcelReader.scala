package sbt.megallink
package script.modules.files.providers

import org.apache.spark.sql.{DataFrame, SparkSession}
import javax.inject.Inject
import com.crealytics.spark.excel._

class ExcelReader @Inject()(sparkSession: SparkSession){
  def read(filePath: String,dataAddress:String="A0"): DataFrame = {
    sparkSession.read.excel(
      header = true,
      dataAddress = dataAddress
    ).load(filePath)
  }
}
