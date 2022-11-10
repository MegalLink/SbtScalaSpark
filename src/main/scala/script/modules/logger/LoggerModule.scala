package sbt.megallink
package script.modules.logger

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import org.apache.log4j.Logger

class LoggerModule extends AbstractModule with ScalaModule {
  override def configure():Unit={
    bind[Logger].toInstance(Log4JLogger.logger)
  }
}
