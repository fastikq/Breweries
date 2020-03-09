package andrey.dudukov.breweries.model.network

import andrey.dudukov.breweries.model.network.entity.BreweryAPI
import retrofit2.http.*

interface API {

    @GET(value = "/breweries")
    suspend fun getBreweries(): List<BreweryAPI>

    @GET(value = "/breweries")
    suspend fun searchBreweries(@Query("by_name") searchQuery: String): List<BreweryAPI>
}