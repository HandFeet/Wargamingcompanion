package co.uk.outlook.davidslambert.data.setup.repositories

import co.uk.outlook.davidslambert.data.setup.mappers.PlayerMapper
import co.uk.outlook.davidslambert.domain.setup.models.PlayerDomain

class PlayerRepository(val dataSource : PlayerDataSource) {

    private val playerMapper = PlayerMapper()

    fun get(id : Long) : PlayerDomain? = dataSource.get(id)?.let { playerMapper.to(it) }

    fun getAll() : List<PlayerDomain> = dataSource.getAll().map { playerMapper.to(it) }

    fun add(player : PlayerDomain) = dataSource.add(playerMapper.to(player))

    fun remove(player : PlayerDomain) = dataSource.remove(playerMapper.to(player))

}