package andrey.dudukov.breweries.core.base.view_model

import andrey.dudukov.breweries.utils.logger.Logger
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    val toastResLD: MutableLiveData<Int> = MutableLiveData()

    private val job: Job = SupervisorJob()

    final override val coroutineContext =
        Dispatchers.Main.immediate + job + CoroutineExceptionHandler { _, e -> errorHandler(e) }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }

    open fun errorHandler(exception: Throwable) = Logger.e(exception)
}