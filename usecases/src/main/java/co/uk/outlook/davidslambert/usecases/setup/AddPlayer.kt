package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.PlayerMapper
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.repositories.PlayerRepository

class AddPlayer(private val playerRepo: PlayerRepository) {
    private val playerMapper = PlayerMapper()

    suspend operator fun invoke(player : PlayerData) {
        return playerRepo.add(playerMapper.to(player))
    }

}