package co.uk.outlook.davidslambert.data.game.repositories

import co.uk.outlook.davidslambert.data.game.model.TurnData

interface TurnDataSource {

    fun get(turnNumber : Int, gameId : Long) : TurnData?

    fun add(turnData: TurnData)

}