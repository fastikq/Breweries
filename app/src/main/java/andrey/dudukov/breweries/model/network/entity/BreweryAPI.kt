package andrey.dudukov.breweries.model.network.entity

import com.google.gson.annotations.SerializedName

data class BreweryAPI(
    val id: Int,
    val name: String,
    val street: String?,
    val city: String?,
    val state: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    @SerializedName("website_url")
    val websiteUrl: String?
)