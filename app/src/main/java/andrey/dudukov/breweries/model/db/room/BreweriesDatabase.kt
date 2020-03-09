package andrey.dudukov.breweries.model.db.room

import andrey.dudukov.breweries.BuildConfig
import andrey.dudukov.breweries.model.db.room.dao.BreweriesDao
import andrey.dudukov.breweries.model.db.room.entity.DbBrewery
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbBrewery::class], version = BuildConfig.DB_VERSION, exportSchema = false)
abstract class BreweriesDatabase : RoomDatabase() {

    abstract fun breweriesDao(): BreweriesDao
}