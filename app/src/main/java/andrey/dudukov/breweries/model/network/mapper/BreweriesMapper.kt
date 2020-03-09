package andrey.dudukov.breweries.model.network.mapper

import andrey.dudukov.breweries.core.base.mapper.BaseMapper
import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.model.network.entity.BreweryAPI

object BreweriesMapper : BaseMapper<BreweryAPI, Brewery> {

    private const val DEFAULT_STRING = ""

    override fun from(source: BreweryAPI): Brewery {
        return Brewery(
            id = source.id,
            name = source.name,
            street = source.street ?: DEFAULT_STRING,
            city = source.city ?: DEFAULT_STRING,
            state = source.state ?: DEFAULT_STRING,
            country = source.country ?: DEFAULT_STRING,
            longitude = source.longitude ?: DEFAULT_STRING,
            latitude = source.latitude ?: DEFAULT_STRING,
            phone = source.phone ?: DEFAULT_STRING,
            websiteUrl = source.websiteUrl ?: DEFAULT_STRING
        )
    }
}