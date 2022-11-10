package sbt.megallink
package script

import com.google.inject.{Guice, Injector, Module, Stage => InjectStage}
import script.modules.handler.HandlerModule
import script.modules.logger.LoggerModule
import script.modules.glue.SparkModule

import script.modules.files.FileModule

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

