package co.uk.outlook.davidslambert.usecases.setup

import co.uk.outlook.davidslambert.data.setup.mappers.GameMapper
import co.uk.outlook.davidslambert.data.setup.mappers.ValidationMapper
import co.uk.outlook.davidslambert.data.setup.model.GameData
import co.uk.outlook.davidslambert.data.setup.model.ValidationData
import co.uk.outlook.davidslambert.domain.setup.logic.GameService

class ValidateGameAction {

    private val service = GameService()
    private val validationMapper = ValidationMapper()
    private val gameMapper = GameMapper()

    fun validate(game : GameData) : ValidationData{
        return validationMapper.to(
            service.validate(gameMapper.to(game)))
    }

}