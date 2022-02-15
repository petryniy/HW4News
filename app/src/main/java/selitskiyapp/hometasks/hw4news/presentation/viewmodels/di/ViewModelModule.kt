package selitskiyapp.hometasks.hw4news.presentation.viewmodels.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.NewsSharedViewModel

val viewModelModule = module {
    viewModel {
        NewsSharedViewModel(repository = get())
    }

//    viewModel {
//        NewsDaoViewModel(repository = get())
//    }
}