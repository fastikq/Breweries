package andrey.dudukov.breweries.core.base.activity

import andrey.dudukov.breweries.utils.logger.Logger
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    private val job: Job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception)
    }

    final override val coroutineContext = Dispatchers.Main + job + exceptionHandler

    @LayoutRes
    abstract fun getLayoutResID(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
    }

    open fun onError(throwable: Throwable) = Logger.e(exception = throwable)

    fun toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    fun toast(@StringRes resId: Int) = toast(getString(resId))

    inline fun <A : RecyclerView.Adapter<*>, T> updateWithDiff(
        adapter: A,
        oldList: MutableList<T>,
        newList: List<T>,
        crossinline compareItemsAreTheSame: (Pair<T, T>) -> Boolean,
        detectMoves: Boolean = true
    ) = launch(Dispatchers.IO) {
        val diffResult = DiffUtil.calculateDiff(
            object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    compareItemsAreTheSame(oldList[oldItemPosition] to newList[newItemPosition])

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    oldList[oldItemPosition] == newList[newItemPosition]

                override fun getOldListSize() = oldList.size

                override fun getNewListSize() = newList.size
            },
            detectMoves
        )
        withContext(Dispatchers.Main) {
            oldList.clear()
            oldList.addAll(newList)
            diffResult.dispatchUpdatesTo(adapter)
        }
    }
}