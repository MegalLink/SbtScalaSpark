package sbt.megallink
package script.modules.spark.providers

import com.google.inject.Inject
import org.apache.spark.sql.SparkSession

class SparkTest @Inject()(sparkSession: SparkSession){
    def testRdd(): Unit ={
      println("RDDManagement")
    }
}