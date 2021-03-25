package co.uk.outlook.davidslambert.domain.setup.models

data class ValidationDomain(
    val isValid : Boolean,
    val errorMessage : String
)