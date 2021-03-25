package co.uk.outlook.davidslambert.data.setup.mappers

import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.domain.setup.models.PlayerDomain

class PlayerMapper {

    fun to(player : PlayerDomain) : PlayerData = PlayerData(
            player.name, player.gameId, player.commandPoints, player.score, player.id)

    fun to(player : PlayerData) : PlayerDomain = PlayerDomain(
            player.name, player.gameId, player.commandPoints, player.score, player.id)


}