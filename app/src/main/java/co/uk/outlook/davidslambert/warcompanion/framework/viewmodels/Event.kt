package co.uk.outlook.davidslambert.warcompanion.framework.viewmodels

class Event <out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandledOrReturnNull(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

}