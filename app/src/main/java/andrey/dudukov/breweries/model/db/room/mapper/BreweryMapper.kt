package andrey.dudukov.breweries.model.db.room.mapper

import andrey.dudukov.breweries.core.base.mapper.BaseMapper
import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.model.db.room.entity.DbBrewery

object BreweryMapper : BaseMapper<Brewery, DbBrewery> {

    override fun from(source: Brewery): DbBrewery {
        return DbBrewery(
            id = source.id,
            name = source.name,
            street = if (source.street.isEmpty()) null else source.street,
            city = if (source.city.isEmpty()) null else source.city,
            state = if (source.state.isEmpty()) null else source.state,
            country = if (source.country.isEmpty()) null else source.country,
            longitude = if (source.longitude.isEmpty()) null else source.longitude,
            latitude = if (source.latitude.isEmpty()) null else source.latitude,
            phone = if (source.phone.isEmpty()) null else source.phone,
            websiteUrl = if (source.websiteUrl.isEmpty()) null else source.websiteUrl
        )
    }
}