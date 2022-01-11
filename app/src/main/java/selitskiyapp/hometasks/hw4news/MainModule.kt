package selitskiyapp.hometasks.hw4news

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.domain.NewsInteractor
import selitskiyapp.hometasks.hw4news.domain.NewsInteractorImpl
import selitskiyapp.hometasks.hw4news.network.NewsApi
import selitskiyapp.hometasks.hw4news.network.RetrofitClient
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsViewModel

val mainModule = module {
    viewModel {
        NewsViewModel(
            interactor = get()
        )
    }

    single<NewsInteractor> {
        NewsInteractorImpl(
            newsApi = get()
        )
    }

    single<NewsApi> {
        RetrofitClient.getNewsApi()
    }
}