package co.uk.outlook.davidslambert.data.setup.repositories

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.domain.setup.models.GameDomain


class GameRepository(val dataSource: GameDataSource) {

    private val gameMapper = GameMapper()

    fun get(id : Long) : GameDomain? = dataSource.get(id)?.let { gameMapper.to(it) }

    fun getAll() : List<GameDomain> = dataSource.getAll().map { gameMapper.to(it) }

    fun add(gameDomain : GameDomain) : Long = dataSource.add(gameMapper.to(gameDomain))

    fun remove(gameDomain : GameDomain) = dataSource.remove(gameMapper.to(gameDomain))

}