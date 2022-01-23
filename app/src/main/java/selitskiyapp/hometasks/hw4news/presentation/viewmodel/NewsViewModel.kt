package selitskiyapp.hometasks.hw4news.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import selitskiyapp.hometasks.hw4news.data.dao.NewsEntity
import selitskiyapp.hometasks.hw4news.domain.NewsInteractor
import selitskiyapp.hometasks.hw4news.presentation.objects.News

class NewsViewModel(private val interactor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> get() = _news

    fun onNewsItemClicked(position: Int) {
        val item = _news.value?.get(position) ?: return
        val list = _news.value?.toMutableList() ?: return
        list[position] = item.copy(isChecked = !item.isChecked)
        _news.value = list

        insertToDataNews(item)
    }

    fun loadNetworkNews() {
        viewModelScope.launch {
            _news.value = interactor.getNetworkNews()
        }
    }

    fun insertToDataNews(news: News) {
        viewModelScope.launch {
            interactor.insertDataNews(news)
        }
    }



    fun deleteDataNews(title: String?) {
        viewModelScope.launch {
            interactor.deleteDataNews(title)
        }
    }
}