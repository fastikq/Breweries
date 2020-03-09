package andrey.dudukov.breweries.utils.extension

import android.text.Editable

fun Editable?.isNotEmpty(block: (String) -> Unit) {
    this?.let { block.invoke(it.toString()) }
}