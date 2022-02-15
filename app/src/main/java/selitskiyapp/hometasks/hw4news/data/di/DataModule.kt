package selitskiyapp.hometasks.hw4news.data.di

import androidx.room.Room
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.data.dao.AppDatabase
import selitskiyapp.hometasks.hw4news.data.network.RetrofitClient

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "USERDB"
        ).build()
    }
    single {
        get<AppDatabase>().getNewsDao()
    }

    single {
        RetrofitClient.getNewsApi()
    }
}