package sbt.megallink
package script.modules.files

import com.google.inject.{AbstractModule, Provides, Singleton}
import net.codingwell.scalaguice.ScalaModule
import script.modules.files.providers.{CSVReader, DataFrameMapper}

import sbt.megallink.script.modules.files.implementations.FileManager
import sbt.megallink.script.modules.files.repositories.FileRepository

class FileModule() extends AbstractModule with ScalaModule{
  var repository:Option[FileRepository] = None

  @Provides
  @Singleton
  def provideRepository(
                         csvReader: CSVReader,
                         dataFrameMapper: DataFrameMapper
                       ): FileRepository = repository.getOrElse(new FileManager(csvReader,dataFrameMapper))


  override def configure(): Unit = {
    bind[CSVReader].in[Singleton]
    bind[DataFrameMapper].in[Singleton]
  }
}
