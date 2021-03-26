package co.uk.outlook.davidslambert.warcompanion.presention.di

import co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.gamecreation.AddGameFragment
import co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.playercreation.PlayerViewpagerFragment
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface ViewModelComponent {

    fun inject(addGame: AddGameFragment)

    fun inject(addPlayers : PlayerViewpagerFragment)

}