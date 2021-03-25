package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository
import co.uk.outlook.davidslambert.usecases.setup.GetGames
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.GameDataSourceImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseGameSelectorViewModel(app : Application) : AndroidViewModel(app) {

    private val coroutine = CoroutineScope(Dispatchers.IO)
    private val getGames = GetGames(GameRepository(GameDataSourceImpl(app.applicationContext)))

    val games = MutableLiveData<List<GameData>>()

    fun loadGames() {
        coroutine.launch {
            games.postValue(applyFilter(getGames.invoke()))
        }
    }

    abstract fun applyFilter(gameData: List<GameData>) : List<GameData>

}