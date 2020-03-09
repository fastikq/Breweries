package andrey.dudukov.breweries.utils.logger

import timber.log.Timber
import java.io.PrintWriter
import java.io.StringWriter

object Logger {

    fun e(exception: Throwable? = null, message: String? = exception?.message) {
        exception?.printStackTrace()
        Timber.e(message)
    }

    fun w(message: String) {
        Timber.w(message)
    }

    fun network(message: String) {
        Timber
            .tag("Network")
            .e(message)
    }
}