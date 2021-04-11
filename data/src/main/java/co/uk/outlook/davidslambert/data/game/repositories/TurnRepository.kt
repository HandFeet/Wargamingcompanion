package co.uk.outlook.davidslambert.data.game.repositories

import co.uk.outlook.davidslambert.data.game.mappers.TurnMapper
import co.uk.outlook.davidslambert.data.game.model.TurnData
import co.uk.outlook.davidslambert.domain.game.model.TurnDomain

class TurnRepository(private val turnDataSource: TurnDataSource) {

   private  val turnMapper = TurnMapper()

    fun add(turnDomain: TurnDomain) = turnDataSource.add(turnMapper.to(turnDomain))


    fun get(turnNumber : Int, gameId: Long) : TurnData? = turnDataSource.get(turnNumber, gameId)


}