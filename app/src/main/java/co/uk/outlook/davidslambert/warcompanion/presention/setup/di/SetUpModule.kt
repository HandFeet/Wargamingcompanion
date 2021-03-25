package co.uk.outlook.davidslambert.warcompanion.presention.setup.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.AddGameViewModel
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class SetUpModule(private val owner : ViewModelStoreOwner) {

    @Provides
    fun providesViewModel() : AddGameViewModel =
        ViewModelProvider(owner).get(AddGameViewModel::class.java)

    @Provides
    fun providesBlankData() : GameData =
        GameData("", false, Date(), 0)

}