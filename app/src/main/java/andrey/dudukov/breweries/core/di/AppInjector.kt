package andrey.dudukov.breweries.core.di

import andrey.dudukov.breweries.feature.main.MainViewModel
import andrey.dudukov.breweries.model.db.DatabaseManager
import andrey.dudukov.breweries.model.db.room.DatabaseManagerImpl
import andrey.dudukov.breweries.model.network.NetworkManager
import andrey.dudukov.breweries.model.network.NetworkManagerImpl
import andrey.dudukov.breweries.repository.breweries.BreweriesRepository
import andrey.dudukov.breweries.repository.breweries.BreweriesRepositoryImpl
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object AppInjector {

    fun setup(context: Context) {
        startKoin {
            androidContext(context)
            modules(listOf(viewModelsModule, managersModule, repositoriesModule))
        }
    }

    private val managersModule = module {
        single<NetworkManager> { NetworkManagerImpl() }
        single<DatabaseManager> { DatabaseManagerImpl(androidContext()) }
    }

    private val repositoriesModule = module {
        factory<BreweriesRepository> { BreweriesRepositoryImpl(get(), get()) }
    }

    private val viewModelsModule = module {
        viewModel { MainViewModel(get()) }
    }
}