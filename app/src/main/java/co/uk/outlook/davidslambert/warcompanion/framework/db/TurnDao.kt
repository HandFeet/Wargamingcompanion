package co.uk.outlook.davidslambert.warcompanion.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.uk.outlook.davidslambert.warcompanion.framework.models.TurnEntity

@Dao
interface TurnDao {

    @Query("SELECT * FROM turn WHERE turn_number = :turnNumber AND game_id = :gameId")
    fun get(gameId : Long, turnNumber : Int) : TurnEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(turnEntity: TurnEntity)

}