package sbt.megallink
package script.modules.glue

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import org.apache.spark.sql.SparkSession

class SparkModule extends AbstractModule with ScalaModule {
  override def configure():Unit={
    bind[SparkSession].toInstance(LocalSpark.localSparkSession())
  }
}