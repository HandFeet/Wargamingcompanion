package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.PlayerMapper
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.repositories.PlayerRepository

class GetPlayers(private val playerRepository: PlayerRepository) {

    private val playerMapper = PlayerMapper()

    operator fun invoke(id : Long) : List<PlayerData> {
        return playerRepository.getAllForGame(id).map { playerMapper.to(it) }
    }

}