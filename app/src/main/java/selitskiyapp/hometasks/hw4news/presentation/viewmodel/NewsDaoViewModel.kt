package selitskiyapp.hometasks.hw4news.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import selitskiyapp.hometasks.hw4news.domain.NewsInteractor
import selitskiyapp.hometasks.hw4news.presentation.objects.News

class NewsDaoViewModel(private val interactor: NewsInteractor) : ViewModel() {
    val daoNews: LiveData<List<News>> = interactor.getDataLiveNews()

    fun deleteDataNews(title: String?) {
        viewModelScope.launch {
            interactor.deleteDataNews(title)
        }
    }
}