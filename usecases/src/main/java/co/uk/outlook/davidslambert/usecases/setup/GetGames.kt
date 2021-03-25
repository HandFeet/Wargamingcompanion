package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository


class GetGames(val gameRepository: GameRepository) {

    private val gameMapper = GameMapper()

    suspend operator fun invoke() : List<GameData> {
        return gameRepository.getAll().map { gameMapper.to(it) };
    }

}