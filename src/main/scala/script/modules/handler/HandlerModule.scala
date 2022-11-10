package sbt.megallink
package script.modules.handler

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

class HandlerModule extends AbstractModule with ScalaModule{
  override def configure(): Unit = {
    bind[MainHandler]
  }
}
