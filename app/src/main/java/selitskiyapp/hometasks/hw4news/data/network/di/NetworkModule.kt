package selitskiyapp.hometasks.hw4news.data.network.di

import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.data.network.RetrofitClient

val networkModule = module {
    single {
        RetrofitClient.getNewsApi()
    }


}