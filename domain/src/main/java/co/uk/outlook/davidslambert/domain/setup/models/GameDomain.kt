package co.uk.outlook.davidslambert.domain.setup.models

import java.util.*

data class GameDomain(
    var name : String,
    var complete : Boolean,
    var start : Date,
    var numberOfPlayers : Long,
    var id : Long = 0)