package co.uk.outlook.davidslambert.warcompanion.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.uk.outlook.davidslambert.warcompanion.framework.models.GameEntity
import co.uk.outlook.davidslambert.warcompanion.framework.models.PlayerEntity

@Database(entities = [GameEntity::class, PlayerEntity::class], version = 1, exportSchema = false)
abstract class DatabaseService : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "game.db"

        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): DatabaseService =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun gameDao() : GameDao

    abstract fun playerDao() : PlayerDao

}