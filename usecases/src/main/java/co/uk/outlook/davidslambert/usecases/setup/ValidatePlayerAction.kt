package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.PlayerMapper
import co.uk.outlook.davidslambert.data.setup.mappers.ValidationMapper
import co.uk.outlook.davidslambert.data.setup.model.PlayerData
import co.uk.outlook.davidslambert.data.setup.model.ValidationData
import co.uk.outlook.davidslambert.domain.setup.logic.PlayerService

class ValidatePlayerAction {

    private val service = PlayerService()
    private val validationMapper = ValidationMapper()
    private val playerMapper = PlayerMapper()

    fun validate(player : PlayerData) : ValidationData {
        return validationMapper.to(
            service.validate(playerMapper.to(player)))
    }

}