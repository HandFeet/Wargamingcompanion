package co.uk.outlook.davidslambert.warcompanion.framework.di

import co.uk.outlook.davidslambert.warcompanion.framework.datasource.GameDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.PlayerDataSourceImpl
import co.uk.outlook.davidslambert.warcompanion.framework.datasource.TurnDataSourceImpl
import dagger.Component

@Component(modules = [GameModule::class])
interface GameComponent {

    fun inject(dataSource : GameDataSourceImpl)

    fun inject(dataSource : PlayerDataSourceImpl)

    fun inject(dataSource: TurnDataSourceImpl)

}