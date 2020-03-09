package andrey.dudukov.breweries.model.network

import andrey.dudukov.breweries.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkInitializer {

    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val converterFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val adapterFactory: CoroutineCallAdapterFactory = CoroutineCallAdapterFactory()

    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openbrewerydb.org")
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(adapterFactory)
        .build()
}