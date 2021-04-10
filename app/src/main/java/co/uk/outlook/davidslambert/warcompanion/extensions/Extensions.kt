package co.uk.outlook.davidslambert.warcompanion.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.LayoutRes
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
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
