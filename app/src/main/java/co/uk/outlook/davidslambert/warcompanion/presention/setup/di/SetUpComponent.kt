package co.uk.outlook.davidslambert.warcompanion.presention.setup.di

import co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.AddGameFragment
import dagger.Component

@Component(modules = [SetUpModule::class])
interface SetUpComponent {

    fun inject(addGame: AddGameFragment)

}