package co.uk.outlook.davidslambert.warcompanion.framework.datasource

import android.content.Context
import co.uk.outlook.davidslambert.data.game.model.TurnData
import co.uk.outlook.davidslambert.data.game.repositories.TurnDataSource
import co.uk.outlook.davidslambert.warcompanion.framework.db.DatabaseService
import co.uk.outlook.davidslambert.warcompanion.framework.di.DaggerGameComponent
import co.uk.outlook.davidslambert.warcompanion.framework.di.GameModule
import co.uk.outlook.davidslambert.warcompanion.framework.mappers.TurnMapper
import javax.inject.Inject

class TurnDataSourceImpl(context: Context)  : TurnDataSource {

    private val turnMapper = TurnMapper()

    @Inject
    lateinit var databaseService : DatabaseService

    init {
        DaggerGameComponent
            .builder()
            .gameModule(GameModule(context))
            .build()
            .inject(this)
    }

    override fun get(turnNumber : Int, gameId: Long): TurnData? {
        return databaseService.turnDao().get(gameId, turnNumber)?.let { turnMapper.to(it) }
    }
    override fun add(turnData: TurnData) {
        databaseService.turnDao().add(turnMapper.to(turnData))
    }

}