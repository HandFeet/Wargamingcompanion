package co.uk.outlook.davidslambert.warcompanion.framework.mappers

import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.framework.models.PlayerEntity

class PlayerMapper {

    fun to(player : PlayerEntity) : PlayerData = PlayerData(
            player.name, player.gameId, player.commandPoints, player.score, player.id)

    fun to(player : PlayerData) : PlayerEntity = PlayerEntity(
            player.name, player.gameId, player.commandPoints, player.score, player.id)


}