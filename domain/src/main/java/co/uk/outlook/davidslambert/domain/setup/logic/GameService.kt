package co.uk.outlook.davidslambert.domain.setup.logic

import co.uk.outlook.davidslambert.domain.setup.models.GameDomain
import co.uk.outlook.davidslambert.domain.setup.models.PlayerDomain
import co.uk.outlook.davidslambert.domain.setup.models.ValidationDomain

class GameService {

    fun validate(game : GameDomain) : ValidationDomain {
        if (game.name.isBlank()) {
            return ValidationDomain(false, NO_NAME_ERROR)
        } else if (game.numberOfPlayers < 1L) {
            return ValidationDomain(false, NOT_ENOUGH_PLAYERS_ERROR)
        }
        return ValidationDomain(true, NO_ERROR)
    }

    companion object {
        const val NO_NAME_ERROR = "The game name is required"
        const val NOT_ENOUGH_PLAYERS_ERROR = "There must be at least one player"
        const val NO_ERROR = ""
    }

}