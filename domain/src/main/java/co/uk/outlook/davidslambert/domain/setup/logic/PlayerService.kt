package co.uk.outlook.davidslambert.domain.setup.logic

import co.uk.outlook.davidslambert.domain.setup.models.PlayerDomain
import co.uk.outlook.davidslambert.domain.setup.models.ValidationDomain

class PlayerService {

    fun validate(player : PlayerDomain) : ValidationDomain {
        if (player.name.isBlank()) {
            return ValidationDomain(false, NO_NAME_ERROR)
        }
        return ValidationDomain(true, NO_ERROR)
    }

    companion object {
        const val NO_NAME_ERROR = "The player name is required"
        const val NO_ERROR = ""
    }

}