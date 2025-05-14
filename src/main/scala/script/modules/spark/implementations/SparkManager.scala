package sbt.megallink
package script.modules.spark.implementations

import script.modules.spark.repositories.MySparkRepository

import com.google.inject.Inject
import sbt.megallink.script.modules.spark.providers.SparkTest

class MySparkManager @Inject()(sparkTest:SparkTest) extends MySparkRepository{
  override def testRdd(): Unit = sparkTest.testRdd()
}