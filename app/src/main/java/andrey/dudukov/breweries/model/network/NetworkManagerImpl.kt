package andrey.dudukov.breweries.model.network

import andrey.dudukov.breweries.model.network.mapper.BreweriesMapper
import retrofit2.Retrofit

class NetworkManagerImpl : NetworkManager {

    private val retrofit: Retrofit by lazy { NetworkInitializer.provideRetrofit() }
    private val api: API by lazy { retrofit.create(API::class.java) }

    override suspend fun getBreweries() = api.getBreweries().map { BreweriesMapper.from(it) }

    override suspend fun searchBreweries(query: String) = api.searchBreweries(query).map { BreweriesMapper.from(it) }
}