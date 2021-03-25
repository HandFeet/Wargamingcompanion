package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository

class RemoveGame (private val gameRepository: GameRepository) {

    private val gameMapper = GameMapper()

    suspend operator fun invoke(game : GameData)  {
        gameRepository.remove(gameMapper.to(game))
    }

}