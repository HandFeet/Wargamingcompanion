 package co.uk.outlook.davidslambert.warcompanion.presention.setup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.extensions.getLongNoNulls
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.AddGameViewModel
import co.uk.outlook.davidslambert.warcompanion.presention.setup.di.DaggerSetUpComponent
import co.uk.outlook.davidslambert.warcompanion.presention.setup.di.SetUpModule
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.util.*
import javax.inject.Inject

class AddGameFragment : Fragment() {

    @Inject
    lateinit var viewModel : AddGameViewModel

    @Inject
    lateinit var data : GameData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerSetUpComponent.builder().setUpModule(SetUpModule(this)).build().inject(this)
        setClickListeners()
        setObservers()
    }

    private fun setClickListeners() {
        add_game.setOnClickListener{
            data.name = game_name.text.toString()
            data.numberOfPlayers = number_of_players.getLongNoNulls()
            data.start = Date(System.currentTimeMillis())
            data.complete = false
            viewModel.add(data)
        }
    }

    private fun setObservers() {
        viewModel.added.observe(viewLifecycleOwner, {
            if (!it.hasBeenHandled) {
                data.id = it.getContentIfNotHandledOrReturnNull()!!
                goToNoteDetails(data.id)
            }
        })
        viewModel.validation.observe(viewLifecycleOwner, {
            error_message.text = it.errorMessage
        })
    }

    private fun goToNoteDetails(id : Long = 0) {
        val action = AddGameFragmentDirections.goToPlayerSetup()
        action.gameId = id
        Navigation.findNavController(error_message).navigate(action)
    }

}