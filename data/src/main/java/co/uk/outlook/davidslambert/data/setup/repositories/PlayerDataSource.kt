package co.uk.outlook.davidslambert.data.setup.repositories

import co.uk.outlook.davidslambert.data.setup.model.PlayerData

interface PlayerDataSource {

    fun get(id : Long) : PlayerData?

    fun add(player : PlayerData)

    fun remove(player : PlayerData)

    fun getAll(): List<PlayerData>

    fun getAllForGame(id: Long): List<PlayerData>
}