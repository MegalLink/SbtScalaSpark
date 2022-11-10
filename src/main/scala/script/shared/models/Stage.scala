package sbt.megallink
package script.shared.models

object Stage extends Enumeration {
  type Stage = String

  val Dev = "dev"
  val Qa = "qa"

  implicit class RealStage(val stage:Stage) extends AnyVal{
    def isDev:Boolean = stage == Stage.Dev
    def cleanDev(defaultSate:Stage = Stage.Qa):String = if (isDev) defaultSate else stage
  }
}
