package co.uk.outlook.davidslambert.warcompanion.presention.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.presention.game.ui.main.PlayerRecyclerView
import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        setUpPlayerList()
    }
    private fun setUpPlayerList() {
        val players = ArrayList<PlayerData>()
        players.add(PlayerData("Player 1",0,0,0,0))
        players.add(PlayerData("Player 2",0,0,0,1))
        players.add(PlayerData("Player 3",0,0,0,2))


        player_recyclerview.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        player_recyclerview.adapter = PlayerRecyclerView(players)
    }
}