package co.uk.outlook.davidslambert.data.setup.repositories

import co.uk.outlook.davidslambert.data.setup.model.GameData


interface GameDataSource {

    fun get(id : Long) : GameData?

    fun add(game : GameData) : Long

    fun remove(game : GameData)

    fun getAll(): List<GameData>

}