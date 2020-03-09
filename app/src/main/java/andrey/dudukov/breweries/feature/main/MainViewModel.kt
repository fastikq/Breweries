package andrey.dudukov.breweries.feature.main

import andrey.dudukov.breweries.R
import andrey.dudukov.breweries.core.base.view_model.BaseViewModel
import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.entity.error.network.NetworkException
import andrey.dudukov.breweries.repository.breweries.BreweriesRepository
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val breweriesRepository: BreweriesRepository) : BaseViewModel() {

    val breweriesLD: MutableLiveData<List<Brewery>> = MutableLiveData()

    init {
        loadBreweries()
    }

    override fun errorHandler(exception: Throwable) {
        when (exception) {
            is NetworkException -> toastResLD.postValue(R.string.remote_update_failed)
            else -> super.errorHandler(exception)
        }
    }

    fun searchBreweries(query: String) = launch {
        breweriesLD.value = withContext(Dispatchers.IO) { breweriesRepository.searchBreweries(query) }
    }

    private fun loadBreweries() = launch(Dispatchers.IO) {
        breweriesRepository.loadBreweries().collect { withContext(Dispatchers.Main) { breweriesLD.value = it } }
    }
}