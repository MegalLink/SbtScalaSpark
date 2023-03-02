package sbt.megallink
package script.modules.files.implementations

import script.modules.files.repositories.FileRepository
import script.modules.files.providers.{CSVReader, DataFrameMapper, ExcelReader}
import sbt.megallink.script.modules.files.implementations.models.Hero

class FileManager(
          csvReader: CSVReader,
          excelReader: ExcelReader,
          dataFrameMapper:DataFrameMapper
                 ) extends FileRepository {
  override def getHeroesFromCsv(filePath:String):List[Hero] = {
    val df=csvReader.read(filePath)
    dataFrameMapper.mapDataframeToHero(df)
  }

  override def getHeroesFromExcel(filePath:String):List[Hero] = {
    val df=excelReader.read(filePath,"A4")
    dataFrameMapper.mapDataframeToHero(df)
  }
}
