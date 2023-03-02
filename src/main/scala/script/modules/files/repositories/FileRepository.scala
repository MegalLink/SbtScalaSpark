package sbt.megallink
package script.modules.files.repositories

import script.modules.files.implementations.models.Hero

trait FileRepository {
  def getHeroesFromCsv(filePath:String):List[Hero]
  def getHeroesFromExcel(filePath:String):List[Hero]
}
