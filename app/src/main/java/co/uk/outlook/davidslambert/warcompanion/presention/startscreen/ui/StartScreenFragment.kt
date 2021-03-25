package co.uk.outlook.davidslambert.warcompanion.presention.startscreen.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.completegameselector.CompleteGameSelectorActivity
import co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase.resumegameselector.ResumeGameSelectorActivity
import co.uk.outlook.davidslambert.warcompanion.presention.setup.ui.SetUpActivity
import kotlinx.android.synthetic.main.fragment_start_screen.*


class StartScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newGame.setOnClickListener {
            val intent = Intent(context, SetUpActivity::class.java)
            startActivity(intent)
        }
        resumeGame.setOnClickListener {
            val intent = Intent(context, ResumeGameSelectorActivity::class.java)
            startActivity(intent)
        }
        pastGames.setOnClickListener {
            val intent = Intent(context, CompleteGameSelectorActivity::class.java)
            startActivity(intent)
        }
        settings.setOnClickListener {

        }
    }

}