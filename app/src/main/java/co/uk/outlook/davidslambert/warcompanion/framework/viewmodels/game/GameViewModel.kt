package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository
import co.uk.outlook.davidslambert.data.setup.repositories.PlayerRepository
import co.uk.outlook.davidslambert.usecases.setup.GetGame
import co.uk.outlook.davidslambert.usecases.setup.GetPlayers
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.GameDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.PlayerDataSourceImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(app : Application) : AndroidViewModel(app) {

    private val coroutine = CoroutineScope(Dispatchers.IO)
    private val getGame = GetGame(GameRepository(GameDataSourceImpl(getApplication())))
    private val getPlayers = GetPlayers(PlayerRepository(PlayerDataSourceImpl(getApplication())))

    private val gameObservable = MutableLiveData<GameData>()
    private val playersObservable = MutableLiveData<List<PlayerData>>()

    fun getData(id : Long) {
        coroutine.launch {
            playersObservable.postValue(getPlayers.invoke(id))
        }

        coroutine.launch {
            gameObservable.postValue(getGame.invoke(id))
        }
    }

}