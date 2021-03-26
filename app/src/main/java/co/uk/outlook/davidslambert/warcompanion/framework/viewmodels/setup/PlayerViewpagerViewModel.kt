package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.model.ValidationData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository
import co.uk.outlook.davidslambert.data.setup.repositories.PlayerRepository
import co.uk.outlook.davidslambert.usecases.setup.AddPlayer
import co.uk.outlook.davidslambert.usecases.setup.GetGame
import co.uk.outlook.davidslambert.usecases.setup.ValidatePlayerAction
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.GameDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.PlayerDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewpagerViewModel(app: Application) : AndroidViewModel(app) {

    private val getGame = GetGame(GameRepository(GameDataSourceImpl(getApplication())))
    private val playerValidator = ValidatePlayerAction()
    private val coroutine = CoroutineScope(Dispatchers.IO)
    private val savePlayerAction = AddPlayer(PlayerRepository(PlayerDataSourceImpl(getApplication())))

    val data = MutableLiveData<GameData>()

    fun getGame(id : Long) {
        coroutine.launch {
            data.postValue(getGame.invoke(id))
        }
    }

    val validationResult = MutableLiveData<Pair<Int, ValidationData>>()
    val added = MutableLiveData<Event<Boolean>>()

    fun validate(players : Map<Int, PlayerData>) {
        coroutine.launch {
            var errorFound = false
            players.entries.forEach {
                if (!errorFound) {
                    val data = playerValidator.validate(it.value)
                    errorFound = !data.isValid
                    validationResult.postValue(Pair(it.key, data))
                }
            }
            if (!errorFound) {
                players.entries.forEach {
                    savePlayerAction.invoke(it.value)
                }
                added.postValue(Event(true))
            }
        }
    }


}