package co.uk.outlook.davidslambert.warcompanion.presention.setup.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.setup.PlayerViewpagerViewModel
import kotlinx.android.synthetic.main.fragment_player_viewpager.*

class PlayerViewpagerFragment : Fragment() {

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
        viewModel =  ViewModelProvider(this).get(PlayerViewpagerViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            with(setup_player_viewpager) {
                adapter = PlayerViewpagerAdapter(childFragmentManager)
                with (adapter as PlayerViewpagerAdapter) {
                    itemNumber = it.numberOfPlayers
                    notifyDataSetChanged()
                }
            }
        })
        viewModel.validationResult.observe(viewLifecycleOwner, {
            if (!it.second.isValid) {
                player_error_message.text = "Error with player ${it.first + 1} : ${it.second.errorMessage}"
            }
        })

        add_player.setOnClickListener{
            with(setup_player_viewpager.adapter as PlayerViewpagerAdapter) {
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
    }

    override fun onResume() {
        super.onResume()
        viewModel.getGame(PlayerViewpagerFragmentArgs.fromBundle(requireArguments()).gameId)
    }

    private class PlayerViewpagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

        val registeredFragments = SparseArray<PlayerFragment>()

        var itemNumber : Long = 0L

        override fun getItem(pos: Int): Fragment = PlayerFragment.newInstance()

        override fun getCount(): Int = itemNumber.toInt()

        override fun getPageTitle(position: Int): CharSequence? = "Player ${position + 1}"

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val fragment = super.instantiateItem(container, position)
            registeredFragments.put(position, fragment as PlayerFragment?)
            return fragment
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            registeredFragments.remove(position)
            super.destroyItem(container, position, `object`)
        }

        fun getPlayerFragment(position: Int) : PlayerFragment ? {
            return registeredFragments.get(position)
        }

    }

}