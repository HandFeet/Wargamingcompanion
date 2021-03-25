package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector

import android.app.Application
import co.uk.outlook.davidslambert.data.setup.model.GameData

class CompleteGameViewModel(app : Application) : BaseGameSelectorViewModel(app) {

    override fun applyFilter(gameData: List<GameData>): List<GameData> {
        return gameData.filter { it.complete }
    }

}