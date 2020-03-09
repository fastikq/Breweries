package andrey.dudukov.breweries.repository.breweries

import andrey.dudukov.breweries.core.base.repository.BaseRepository
import andrey.dudukov.breweries.entity.Brewery
import kotlinx.coroutines.flow.Flow

interface BreweriesRepository : BaseRepository {

    suspend fun loadBreweries(): Flow<List<Brewery>>

    suspend fun searchBreweries(query: String): List<Brewery>
}