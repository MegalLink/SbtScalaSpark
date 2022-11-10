package sbt.megallink
package script.modules.files.services

import com.google.inject.Inject
import script.modules.files.repositories.FileRepository
import script.modules.files.models.Hero

class FileManagerService @Inject()(fileRepository: FileRepository) {
    def getHeroesFromFile(filePath:String):List[Hero]= fileRepository.getHeroesFromCsv(filePath)
}
