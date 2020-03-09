package andrey.dudukov.breweries.repository.breweries

import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.entity.error.network.NetworkException
import andrey.dudukov.breweries.model.db.DatabaseManager
import andrey.dudukov.breweries.model.network.NetworkManager
import kotlinx.coroutines.flow.flow
import java.io.IOException

class BreweriesRepositoryImpl(
    private val networkManager: NetworkManager,
    private val databaseManager: DatabaseManager
) : BreweriesRepository {

    override suspend fun loadBreweries() = flow {
        val breweries = databaseManager.getBreweries().sortedBy { it.id }.take(DEFAULT_AMOUNT_ITEM)
        emit(breweries)
        try {
            val newBreweries = networkManager.getBreweries()
            databaseManager.saveBreweries(newBreweries)
            emit(databaseManager.getBreweries().sortedBy { it.id }.take(DEFAULT_AMOUNT_ITEM))
        } catch (exception: Exception) {
            throw if (exception is IOException) NetworkException() else exception
        }
    }

    override suspend fun searchBreweries(query: String): List<Brewery> {
        return try {
            val foundRemoteBreweries = networkManager.searchBreweries(query).sortedBy { it.id }
            databaseManager.saveBreweries(foundRemoteBreweries)
            foundRemoteBreweries
        } catch (exception: Exception) {
            if (exception is IOException) {
                val foundLocalBreweries = databaseManager.findBreweriesByName(query).sortedBy { it.id }
                if (query.isEmpty()) foundLocalBreweries.take(DEFAULT_AMOUNT_ITEM) else foundLocalBreweries
            } else {
                throw exception
            }
        }
    }

    companion object {
        private const val DEFAULT_AMOUNT_ITEM = 20
    }
}