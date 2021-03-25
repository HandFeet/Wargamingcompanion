package co.uk.outlook.davidslambert.data.setup.mappers

import co.uk.outlook.davidslambert.data.setup.model.ValidationData
import co.uk.outlook.davidslambert.domain.setup.models.ValidationDomain

class ValidationMapper {

    fun to(validation: ValidationData) : ValidationDomain =
        ValidationDomain(validation.isValid, validation.errorMessage)

    fun to(validation: ValidationDomain) : ValidationData =
        ValidationData(validation.isValid, validation.errorMessage)

}