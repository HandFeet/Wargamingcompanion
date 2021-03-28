package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository

class GetGame(private val gameRepository: GameRepository) {

    private val gameMapper = GameMapper()

    suspend operator fun invoke(id : Long) : GameData? {
        return gameRepository.get(id)?.let { gameMapper.to(it) }
    }

}