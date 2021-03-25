package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.model.ValidationData
import co.uk.outlook.davidslambert.data.setup.repositories.GameRepository
import co.uk.outlook.davidslambert.usecases.setup.AddGame
import co.uk.outlook.davidslambert.usecases.setup.ValidateGameAction
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.GameDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddGameViewModel(app : Application) : AndroidViewModel(app) {

    private val coroutine = CoroutineScope(Dispatchers.IO)
    private val addGame = AddGame(GameRepository(GameDataSourceImpl(app)))
    private val validateAction = ValidateGameAction()

    val added = MutableLiveData<Event<Long>>();
    val validation = MutableLiveData<ValidationData>()

    fun add(game : GameData) {
        coroutine.launch {
            val valResults = validateAction.validate(game)
            validation.postValue(valResults)
            if (valResults.isValid) {
                added.postValue(Event(addGame.invoke(game)))
            }
        }
    }

}