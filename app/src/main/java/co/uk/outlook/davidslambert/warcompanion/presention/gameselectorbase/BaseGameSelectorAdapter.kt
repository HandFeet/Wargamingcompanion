package co.uk.outlook.davidslambert.warcompanion.presention.gameselectorbase

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.warcompanion.R
import co.uk.outlook.davidslambert.warcompanion.extensions.setDate
import co.uk.outlook.davidslambert.warcompanion.extensions.setLong
import kotlinx.android.synthetic.main.fragment_resume_game.view.*

class BaseGameSelectorAdapter() : RecyclerView.Adapter<BaseGameSelectorAdapter.ViewHolder>() {

    private val values = ArrayList<GameData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_resume_game, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.gameName.text = item.name
        holder.numberOfPlayers.setLong(item.numberOfPlayers)
        holder.date.setDate(item.start)
    }

    fun setItems(values : List<GameData>) {
        this.values.clear()
        this.values.addAll(values)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gameName: TextView = view.resume_game_name
        val numberOfPlayers: TextView = view.resume_number_of_players
        val date : TextView = view.resume_start_date

        override fun toString(): String {
            return super.toString() + " '" + gameName.text + "'"
        }
    }
}