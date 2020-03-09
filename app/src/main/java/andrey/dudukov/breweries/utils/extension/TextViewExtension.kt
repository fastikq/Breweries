package andrey.dudukov.breweries.utils.extension

import android.text.Editable
import android.widget.TextView

val TextView.inputtedText
    get() = text.toString()

fun Editable?.isNotEmpty(block: (String) -> Unit) {
    this?.let { block.invoke(it.toString()) }
}