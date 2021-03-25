package co.uk.outlook.davidslambert.warcompanion.framework.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(
    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "complete")
    var complete : Boolean,

    @ColumnInfo(name = "start")
    var start : Long,

    @ColumnInfo(name = "numberOfPlayers")
    var numberOfPlayers : Long,

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
    ) {
}