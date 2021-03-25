package co.uk.outlook.davidslambert.warcompanion.extensions

import android.widget.EditText
import android.widget.TextView
import java.text.DateFormat
import java.util.*

fun EditText.getLongNoNulls()  : Long{
   this.text.toString().toLongOrNull() ?.let {
       return this.text.toString().toLong()
   }
    return 0
}

fun TextView.setLong(long : Long) {
    this.text = long.toString()
}

fun TextView.setDate(date : Date) {
    val format = DateFormat.getDateInstance()
    this.text = format.format(date)
}