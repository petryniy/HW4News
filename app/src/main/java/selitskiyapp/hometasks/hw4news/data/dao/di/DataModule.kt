package selitskiyapp.hometasks.hw4news.data.dao.di

import androidx.room.Room
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.data.dao.AppDatabase

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "news"
        ).build()
    }
    single {
        get<AppDatabase>().getNewsDao()
    }
}