package co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.playercreation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.PlayerViewpagerViewModel
import co.uk.outlook.davidslambert.warcompanion.presention.IntentKeys
import co.uk.outlook.davidslambert.warcompanion.presention.di.DaggerViewModelComponent
import co.uk.outlook.davidslambert.warcompanion.presention.di.ViewModelModule
import co.uk.outlook.davidslambert.warcompanion.presention.game.GameActivity
import co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.completegameselector.CompleteGameSelectorActivity
import kotlinx.android.synthetic.main.fragment_player_viewpager.*
import javax.inject.Inject

class PlayerViewpagerFragment : Fragment() {

    @Inject
    lateinit var viewModel : PlayerViewpagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_viewpager, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        injectModule()
        setOnGameLoaded()
        setOnValidateResult()
        setOnAdd()
        setOnConfirmClickListener()
    }
    private fun setOnAdd() {
        viewModel.added.observe(viewLifecycleOwner, {
           if (!it.hasBeenHandled) {
               val intent = Intent(context, GameActivity::class.java)
               intent.putExtra(IntentKeys.GAME_ID, viewModel.data.value!!.id)
               startActivity(intent)
           }
        })
    }

    private fun injectModule() = DaggerViewModelComponent
        .builder()
        .viewModelModule(ViewModelModule(this))
        .build()
        .inject(this)

    private fun setOnValidateResult() =
        viewModel.validationResult.observe(viewLifecycleOwner, {
            if (!it.second.isValid) {
                player_error_message.text = "Error with player ${it.first + 1} : ${it.second.errorMessage}"
            }
        })

    private fun setOnGameLoaded() =
        viewModel.data.observe(viewLifecycleOwner, Observer {
            with(setup_player_viewpager) {
                adapter = PlayerTabViewPager(childFragmentManager)
                with (adapter as PlayerTabViewPager) {
                    itemNumber = it.numberOfPlayers
                    notifyDataSetChanged()
                }
            }
        })

    private fun setOnConfirmClickListener() =
        add_player.setOnClickListener{
            with(setup_player_viewpager.adapter as PlayerTabViewPager) {
                val players = HashMap<Int, PlayerData>()
                for (i in 0 until count) {
                    if (getPlayerFragment(i) == null) {
                        players[i] = PlayerData("", 0, 0, 0)
                    } else {
                        players[i] = getPlayerFragment(i)!!.getPlayer(viewModel.data.value!!)
                    }
                }
                viewModel.validate(players)
            }
        }

    override fun onResume() {
        super.onResume()
        viewModel.getGame(PlayerViewpagerFragmentArgs.fromBundle(requireArguments()).gameId)
    }

}