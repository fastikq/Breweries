package andrey.dudukov.breweries.feature.main

import andrey.dudukov.breweries.R
import andrey.dudukov.breweries.core.base.activity.BaseActivity
import andrey.dudukov.breweries.utils.extension.isNotEmpty
import andrey.dudukov.breweries.utils.extension.observe
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter: BreweriesAdapter by lazy { BreweriesAdapter() }

    override fun getLayoutResID() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        etSearch.hint = "$SEARCH_ICON ${etSearch.hint}"
        etSearch.doAfterTextChanged { etSearch.text.isNotEmpty { viewModel.searchBreweries(it) } }
        observe(viewModel.breweriesLD) { newItems ->
            updateWithDiff(
                adapter = adapter,
                oldList = adapter.items,
                newList = newItems,
                compareItemsAreTheSame = { (old, new) -> old.id == new.id }
            )
        }
        observe(viewModel.toastResLD) { toast(it) }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = RecyclerView.VERTICAL
        rvBreweries.adapter = adapter
        rvBreweries.layoutManager = layoutManager
    }

    companion object {
        private const val SEARCH_ICON = "\uD83D\uDD0D"
    }
}
