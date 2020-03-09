package andrey.dudukov.breweries.model.db.room.mapper

import andrey.dudukov.breweries.core.base.mapper.BaseMapper
import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.model.db.room.entity.DbBrewery

object BreweryMapper : BaseMapper<Brewery, DbBrewery> {

    override fun from(source: Brewery): DbBrewery {
        return DbBrewery(
            id = source.id,
            name = source.name,
            street = source.street,
            city = source.city,
            state = source.state,
            country = source.country,
            longitude = source.longitude,
            latitude = source.latitude,
            phone = source.phone,
            websiteUrl = source.websiteUrl
        )
    }
}