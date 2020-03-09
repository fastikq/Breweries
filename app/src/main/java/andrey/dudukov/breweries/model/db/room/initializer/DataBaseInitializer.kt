package andrey.dudukov.breweries.model.db.room.initializer

import andrey.dudukov.breweries.BuildConfig
import andrey.dudukov.breweries.model.db.room.BreweriesDatabase
import android.content.Context
import androidx.room.Room

class DataBaseInitializer(context: Context) {

    private val database: BreweriesDatabase = Room.databaseBuilder(
        context.applicationContext,
        BreweriesDatabase::class.java, BuildConfig.DB_NAME
    ).build()

    fun getInitDataBase() = database
}