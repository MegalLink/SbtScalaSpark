package sbt.megallink
package script.container

import script.modules.files.FileModule
import script.modules.glue.SparkModule
import script.modules.handler.HandlerModule
import script.modules.logger.LoggerModule

import com.google.inject.{Guice, Injector, Stage => InjectStage}

class InjectorCreator() {
  def build():Injector =
    Guice.createInjector(
      InjectStage.PRODUCTION,
      new LoggerModule(),
      new SparkModule(),
      new FileModule(),
      new HandlerModule(),
    )
}

