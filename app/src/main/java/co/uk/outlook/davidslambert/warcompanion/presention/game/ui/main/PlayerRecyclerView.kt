package co.uk.outlook.davidslambert.warcompanion.presention.game.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.extensions.inflate
import kotlinx.android.synthetic.main.player_list_item.view.*

class PlayerRecyclerView(private val players : List<PlayerData>) : RecyclerView.Adapter<PlayerRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflatedView = parent.inflate(R.layout.player_list_item, false)
        return Holder(inflatedView)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(players[position])
    }
    override fun getItemCount(): Int = players.size

    class Holder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
        }

        fun bind(player : PlayerData) {
            view.player_title.text = player.name
        }

    }

}