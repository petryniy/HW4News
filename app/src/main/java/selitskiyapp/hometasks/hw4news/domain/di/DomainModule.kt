package selitskiyapp.hometasks.hw4news.domain.di


import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.data.NewsRepositoryImpl
import selitskiyapp.hometasks.hw4news.domain.NewsRepository

val domainModule = module {
    single<NewsRepository> {
        NewsRepositoryImpl(
            newsDao = get(),
            newsApi = get()
        )
    }
}