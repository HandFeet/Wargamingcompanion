package co.uk.outlook.davidslambert.warcompanion.framework.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["turn_number", "game_id"], tableName = "turn")
data class TurnEntity(

    @ColumnInfo(name = "turn_number")
    val turnNumber : Int,

    @ColumnInfo(name = "game_id")
    val gameId : Long,

)