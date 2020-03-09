package andrey.dudukov.breweries.core

import andrey.dudukov.breweries.core.di.AppInjector
import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppInjector.setup(this)
    }
}