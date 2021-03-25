package co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.framework.viewmodels.gameselector.BaseGameSelectorViewModel

abstract class BaseGameSelectorFragment : Fragment() {

    lateinit var viewModel : BaseGameSelectorViewModel
    private val resumeGameAdapter = BaseGameSelectorAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resume_game_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = resumeGameAdapter
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = createViewModel()
        viewModel.games.observe(viewLifecycleOwner, {
            resumeGameAdapter.setItems(it)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadGames()
    }

    abstract fun createViewModel() : BaseGameSelectorViewModel

}