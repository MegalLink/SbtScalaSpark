package sbt.megallink
package script.modules.files.services

import com.google.inject.Inject
import script.modules.files.repositories.FileRepository
import sbt.megallink.script.modules.files.implementations.models.Hero

class FileManagerService @Inject()(fileRepository: FileRepository) {
    def getHeroesFromCSVFile(filePath:String):List[Hero]= fileRepository.getHeroesFromCsv(filePath)
    def getHeroesFromExcelFile(filePath:String):List[Hero]= fileRepository.getHeroesFromExcel(filePath)
}
