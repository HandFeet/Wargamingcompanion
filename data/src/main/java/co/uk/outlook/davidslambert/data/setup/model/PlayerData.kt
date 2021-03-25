package co.uk.outlook.davidslambert.data.setup.model

data class PlayerData(
        val name : String,
        val gameId : Long,
        val commandPoints : Long,
        val score : Long,
        val id : Long = 0
)