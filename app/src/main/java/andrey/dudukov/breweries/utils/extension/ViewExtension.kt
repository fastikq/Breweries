package andrey.dudukov.breweries.utils.extension

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Group


fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun TextView.underline() {
    val content = SpannableString(text)
    content.setSpan(UnderlineSpan(), 0, content.length, 0)
    this.text = content
}

fun TextView.setIfNotEmpty(content: String, groupView: Group) {
    if (content.isNotEmpty()) {
        groupView.visible()
        this.text = content
    } else {
        groupView.gone()
    }
}