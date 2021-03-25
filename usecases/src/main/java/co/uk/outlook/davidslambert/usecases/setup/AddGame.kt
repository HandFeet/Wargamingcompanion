package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository

class AddGame(private val gameRepository: GameRepository) {
    private val gameMapper = GameMapper()

    suspend operator fun invoke(game : GameData) : Long {
        return gameRepository.add(gameMapper.to(game))
    }

}