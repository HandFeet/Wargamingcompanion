package co.uk.outlook.davidslambert.data.setup.model

import java.util.*

data class GameData(
    var name : String,
    var complete : Boolean,
    var start : Date,
    var numberOfPlayers : Long,
    var id : Long = 0)