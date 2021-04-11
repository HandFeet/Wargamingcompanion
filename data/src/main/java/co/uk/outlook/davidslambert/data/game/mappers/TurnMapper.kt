package co.uk.outlook.davidslambert.data.game.mappers

import co.uk.outlook.davidslambert.data.game.model.TurnData
import co.uk.outlook.davidslambert.domain.game.model.TurnDomain

class TurnMapper {

    fun to(turn : TurnDomain) : TurnData = TurnData(turn.turnNumber, turn.gameId)

    fun to(turn : TurnData) : TurnDomain = TurnDomain(turn.turnNumber, turn.gameId)

}