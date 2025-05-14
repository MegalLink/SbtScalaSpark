package sbt.megallink
package script.modules.spark

import com.google.inject.{AbstractModule, Provides, Singleton}
import net.codingwell.scalaguice.ScalaModule
import sbt.megallink.script.modules.spark.implementations.{MySparkManager}
import sbt.megallink.script.modules.spark.providers.SparkTest
import sbt.megallink.script.modules.spark.repositories.MySparkRepository

class MySparkModule() extends AbstractModule with ScalaModule{
  var repository:Option[MySparkRepository] = None

  @Provides
  @Singleton
  def provideRepository(
                         sparkTest: SparkTest
                       ): MySparkRepository = repository.getOrElse(new MySparkManager(sparkTest))


  override def configure(): Unit = {
    bind[SparkTest].in[Singleton]
  }
}