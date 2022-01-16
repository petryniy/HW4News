package selitskiyapp.hometasks.hw4news.domain.di

import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.domain.NewsInteractor
import selitskiyapp.hometasks.hw4news.domain.NewsInteractorImpl

val domainModule = module {
    single<NewsInteractor> {
        NewsInteractorImpl(
            newsDao = get(),
            newsApi = get()
        )
    }
}