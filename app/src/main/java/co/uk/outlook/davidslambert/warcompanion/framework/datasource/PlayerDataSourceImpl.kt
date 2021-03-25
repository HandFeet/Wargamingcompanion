package co.uk.outlook.davidslambert.warcompanion.framework.datasource

import android.content.Context
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.repositories.PlayerDataSource
import co.uk.outlook.davidslambert.warcompanion.framework.db.DatabaseService
import co.uk.outlook.davidslambert.warcompanion.framework.di.DaggerGameComponent
import co.uk.outlook.davidslambert.warcompanion.framework.di.GameModule
import co.uk.outlook.davidslambert.warcompanion.framework.mappers.PlayerMapper
import javax.inject.Inject

class PlayerDataSourceImpl(context: Context) : PlayerDataSource {

    @Inject
    lateinit var databaseService : DatabaseService

    @Inject
    lateinit var playerMapper : PlayerMapper

    init {
        DaggerGameComponent
                .builder()
                .gameModule(GameModule(context))
                .build()
                .inject(this)
    }

    override fun get(id: Long): PlayerData? {
        return databaseService.playerDao().get(id)?.let { playerMapper.to(it) }
    }

    override fun add(player: PlayerData) {
        databaseService.playerDao().add(playerMapper.to(player))
    }

    override fun remove(player: PlayerData) {
        databaseService.playerDao().remove(playerMapper.to(player))
    }

    override fun getAll(): List<PlayerData> {
        return databaseService.playerDao().getAll().map { playerMapper.to(it) }
    }
}