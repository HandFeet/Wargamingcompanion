package co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.completegameselector

import androidx.lifecycle.ViewModelProvider
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector.BaseGameSelectorViewModel
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector.CompleteGameViewModel
import co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.BaseGameSelectorFragment

class CompleteGameSelectorFragment : BaseGameSelectorFragment() {

    override fun createViewModel(): BaseGameSelectorViewModel {
        return ViewModelProvider(this).get(CompleteGameViewModel::class.java)
    }

}