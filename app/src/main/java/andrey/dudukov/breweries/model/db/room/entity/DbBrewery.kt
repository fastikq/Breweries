package andrey.dudukov.breweries.model.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breweries")
data class DbBrewery(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "street")
    val street: String?,

    @ColumnInfo(name = "city")
    val city: String?,

    @ColumnInfo(name = "state")
    val state: String?,

    @ColumnInfo(name = "country")
    val country: String?,

    @ColumnInfo(name = "longitude")
    val longitude: String?,

    @ColumnInfo(name = "latitude")
    val latitude: String?,

    @ColumnInfo(name = "phone")
    val phone: String?,

    @ColumnInfo(name = "website_url")
    val websiteUrl: String?
)