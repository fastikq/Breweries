package andrey.dudukov.breweries.model.network

import andrey.dudukov.breweries.core.base.manager.BaseManager
import andrey.dudukov.breweries.entity.Brewery

interface NetworkManager : BaseManager {

    suspend fun getBreweries(): List<Brewery>

    suspend fun searchBreweries(query: String): List<Brewery>
}