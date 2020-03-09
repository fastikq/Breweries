package andrey.dudukov.breweries.model.db

import andrey.dudukov.breweries.core.base.manager.BaseManager
import andrey.dudukov.breweries.entity.Brewery

interface DatabaseManager : BaseManager {

    fun getBreweries(): List<Brewery>

    fun findBreweriesByName(query: String): List<Brewery>

    fun saveBreweries(breweries: List<Brewery>)
}