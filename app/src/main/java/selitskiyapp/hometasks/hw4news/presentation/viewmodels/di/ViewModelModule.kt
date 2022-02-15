package selitskiyapp.hometasks.hw4news.presentation.viewmodels.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.NewsDaoViewModel
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.NewsNetworkViewModel

val viewModelModule = module {
    viewModel {
        NewsNetworkViewModel(repository = get())
    }

//    viewModel {
//        NewsDaoViewModel(repository = get())
//    }
}