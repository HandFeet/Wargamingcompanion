package co.uk.outlook.davidslambert.warcompanion.presention.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.presention.game.ui.main.GameFragment

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        if (savedInstanceState == null) {
            /*supportFragmentManager.beginTransaction()
                .replace(R.id.container, GameFragment.newInstance())
                .commitNow()*/
        }
    }
}