package sbt.megallink
package script.modules.glue

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object LocalSpark {
  def localSparkSession():SparkSession=
    SparkSession.builder()
      .config(
        new SparkConf().setMaster("local[*]")
      )
      .appName("TestSbtScala")
      .getOrCreate()
}
