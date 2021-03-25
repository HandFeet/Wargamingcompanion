package co.uk.outlook.davidslambert.data.setup.mappers

import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.domain.setup.models.GameDomain as DomainGame

class GameMapper {

    fun to(game : DomainGame) : GameData =
        GameData(game.name, game.complete, game.start, game.numberOfPlayers, game.id)

    fun to(game : GameData) : DomainGame =
        DomainGame(game.name, game.complete, game.start, game.numberOfPlayers, game.id)


}