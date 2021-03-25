package co.uk.outlook.davidslambert.warcompanion.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import co.uk.outlook.davidslambert.warcompanion.framework.models.GameEntity

@Dao
interface GameDao {

    @Insert(onConflict = REPLACE)
    fun add(gameEntity: GameEntity) : Long

    @Query(value = "SELECT * FROM game WHERE id = :id")
    fun get(id : Long) : GameEntity?

    @Query(value = "SELECT * FROM game")
    fun getAll() : List<GameEntity>

    @Delete
    fun remove(gameEntity: GameEntity)
}