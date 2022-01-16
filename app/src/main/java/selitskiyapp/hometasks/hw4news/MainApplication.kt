package selitskiyapp.hometasks.hw4news

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import selitskiyapp.hometasks.hw4news.data.dao.di.databaseModule
import selitskiyapp.hometasks.hw4news.data.network.di.networkModule
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.di.viewModelModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(
                databaseModule,
                networkModule,
                viewModelModule
            )
        }
    }
}