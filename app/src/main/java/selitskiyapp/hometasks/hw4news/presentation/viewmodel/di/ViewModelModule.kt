package selitskiyapp.hometasks.hw4news.presentation.viewmodel.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsDaoViewModel
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsViewModel

val viewModelModule = module {
    viewModel {
        NewsViewModel(get())

    }
    viewModel {
        NewsDaoViewModel(get())
    }
}