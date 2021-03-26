package co.uk.outlook.davidslambert.warcompanion.presention.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.AddGameViewModel
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.PlayerViewpagerViewModel
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Scope

@Module
class ViewModelModule(private val owner : ViewModelStoreOwner) {

    @Provides
    fun providesAddGameViewModel() : AddGameViewModel =
        ViewModelProvider(owner).get(AddGameViewModel::class.java)

    @Provides
    fun providersAddPlayersViewModel() : PlayerViewpagerViewModel =
        ViewModelProvider(owner).get(PlayerViewpagerViewModel::class.java)

}