package co.uk.outlook.davidslambert.warcompanion.framework.mappers

import co.uk.outlook.davidslambert.data.game.model.TurnData
import co.uk.outlook.davidslambert.warcompanion.framework.models.TurnEntity

class TurnMapper {

    fun to(turn : TurnData) : TurnEntity = TurnEntity(turn.turnNumber, turn.gameId)

    fun to(turn : TurnEntity) : TurnData = TurnData(turn.turnNumber, turn.gameId)

}