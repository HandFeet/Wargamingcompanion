package co.uk.outlook.davidslambert.domain.setup.models

data class PlayerDomain(
        val name : String,
        val gameId : Long,
        val commandPoints : Long,
        val score : Long,
        val id : Long = 0
)