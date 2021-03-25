package co.uk.outlook.davidslambert.warcompanion.framework.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerEntity (
        @ColumnInfo(name = "name")
        val name : String,

        @ColumnInfo(name = "gameId")
        val gameId : Long,

        @ColumnInfo(name = "commandPoints")
        val commandPoints : Long,

        @ColumnInfo(name = "score")
        val score : Long,

        @PrimaryKey(autoGenerate = true)
        val id : Long = 0
)