package selitskiyapp.hometasks.hw4news.presentation.app

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import selitskiyapp.hometasks.hw4news.data.di.dataModule
import selitskiyapp.hometasks.hw4news.domain.di.domainModule
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.di.viewModelModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(
                dataModule,
                domainModule,
                viewModelModule
            )
        }
    }
}