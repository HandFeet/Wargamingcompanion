package co.uk.outlook.davidslambert.warcompanion.framework.di

import android.content.Context
import co.uk.outlook.davidslambert.warcompanion.framework.db.DatabaseService
import co.uk.outlook.davidslambert.warcompanion.framework.mappers.GameMapper
import co.uk.outlook.davidslambert.warcompanion.framework.mappers.PlayerMapper
import dagger.Module
import dagger.Provides

@Module
class GameModule(val application : Context) {

    @Provides
    fun providesGameMapper() = GameMapper()

    @Provides
    fun providesPlayerMapper() = PlayerMapper()

    @Provides
    fun providesDatabaseService() = DatabaseService.getInstance(application)

}