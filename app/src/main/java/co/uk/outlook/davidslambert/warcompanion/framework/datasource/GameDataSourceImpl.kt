package co.uk.outlook.davidslambert.warcompanion.framework.datasource

import android.content.Context
import co.uk.outlook.davidslambert.warcompanion.framework.db.DatabaseService
import co.uk.outlook.davidslambert.warcompanion.framework.di.GameModule
import co.uk.outlook.davidslambert.warcompanion.framework.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameDataSource
import co.uk.outlook.davidslambert.warcompanion.framework.di.DaggerGameComponent
import javax.inject.Inject

class GameDataSourceImpl(context: Context) : GameDataSource {

    @Inject
    lateinit var databaseService : DatabaseService

    @Inject
    lateinit var gameMapper : GameMapper

    init {
        DaggerGameComponent
            .builder()
            .gameModule(GameModule(context))
            .build()
            .inject(this)
    }

    override fun get(id: Long): GameData? {
        return databaseService.gameDao().get(id)?.let { gameMapper.toType(it) }
    }

    override fun add(game: GameData) : Long =
        databaseService.gameDao().add(gameMapper.toEntity(game))

    override fun remove(game: GameData) {
        databaseService.gameDao().remove(gameMapper.toEntity(game))
    }

    override fun getAll(): List<GameData> {
        return databaseService.gameDao().getAll().map { gameMapper.toType(it) }
    }

}