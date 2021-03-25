package co.uk.outlook.davidslambert.warcompanion.framework.mappers

import co.uk.outlook.davidslambert.warcompanion.framework.models.GameEntity
import co.uk.outlook.davidslambert.data.setup.model.GameData
import java.util.*

class GameMapper {

    fun toEntity(game : GameData) : GameEntity {
        return GameEntity(game.name, game.complete, game.start.time, game.numberOfPlayers, game.id)
    }

    fun toType(game : GameEntity) : GameData {
        return GameData(game.name, game.complete, Date(game.start), game.numberOfPlayers, game.id)
    }

}