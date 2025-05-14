package sbt.megallink
package script.modules.spark.services

import com.google.inject.Inject
import sbt.megallink.script.modules.spark.repositories.MySparkRepository

class SparkService @Inject()(sparkRepository: MySparkRepository) {
  def testRdd():Unit=sparkRepository.testRdd()
}
