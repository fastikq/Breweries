package andrey.dudukov.breweries.model.db.room.dao

import andrey.dudukov.breweries.model.db.room.entity.DbBrewery
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface BreweriesDao {

    @Query("SELECT * FROM breweries")
    fun queryBreweries(): List<DbBrewery>

    @Query("SELECT * FROM breweries WHERE id = :id")
    fun queryBrewery(id: Int): DbBrewery

    @Insert(onConflict = REPLACE)
    fun insert(dbBrewery: DbBrewery)

    @Insert(onConflict = REPLACE)
    fun insertAll(dbBrewery: List<DbBrewery>)

    @Query("SELECT * FROM breweries WHERE name LIKE :query")
    fun findByName(query: String): List<DbBrewery>
}