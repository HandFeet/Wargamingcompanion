package co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.resumegameselector

import androidx.lifecycle.ViewModelProvider
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector.ResumeGameViewModel
import co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.BaseGameSelectorFragment

class ResumeGameSelectorFragment : BaseGameSelectorFragment() {

    override fun createViewModel(): ResumeGameViewModel {
        return ViewModelProvider(this).get(ResumeGameViewModel::class.java)
    }

}