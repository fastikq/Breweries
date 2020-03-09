package andrey.dudukov.breweries.entity

data class Brewery(
    val id: Int,
    val name: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val longitude: String,
    val latitude: String,
    val phone: String,
    val websiteUrl: String
)