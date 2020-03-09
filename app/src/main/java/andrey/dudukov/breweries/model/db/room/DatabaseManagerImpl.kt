package andrey.dudukov.breweries.model.db.room

import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.model.db.DatabaseManager
import andrey.dudukov.breweries.model.db.room.initializer.DataBaseInitializer
import andrey.dudukov.breweries.model.db.room.mapper.BreweryMapper
import andrey.dudukov.breweries.model.db.room.mapper.DbBreweryMapper
import android.content.Context

class DatabaseManagerImpl(context: Context) : DatabaseManager {

    private val database: BreweriesDatabase = DataBaseInitializer(context).getInitDataBase()

    override fun getBreweries() = database.breweriesDao().queryBreweries().map { DbBreweryMapper.from(it) }

    override fun findBreweriesByName(query: String) =
        database.breweriesDao().findBreweriesByName("%$query%").map { DbBreweryMapper.from(it) }

    override fun saveBreweries(breweries: List<Brewery>) {
        database.breweriesDao().insertAll(breweries.map { BreweryMapper.from(it) })
    }
}