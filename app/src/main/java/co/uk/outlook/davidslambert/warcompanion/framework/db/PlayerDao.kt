package co.uk.outlook.davidslambert.warcompanion.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.warcompanion.framework.models.PlayerEntity

@Dao
interface PlayerDao {

    @Insert(onConflict = REPLACE)
    fun add(playerEntity: PlayerEntity)

    @Query(value = "SELECT * FROM player WHERE id = :id")
    fun get(id : Long) : PlayerEntity?

    @Query(value = "SELECT * FROM player")
    fun getAll() : List<PlayerEntity>

    @Delete
    fun remove(playerEntity: PlayerEntity)

    @Query(value = "SELECT * FROM player WHERE gameId = id")
    fun getAllForGame(id: Long): List<PlayerData>
}