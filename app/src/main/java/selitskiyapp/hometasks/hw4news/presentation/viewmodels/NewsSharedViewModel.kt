package selitskiyapp.hometasks.hw4news.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import selitskiyapp.hometasks.hw4news.domain.NewsRepository
import selitskiyapp.hometasks.hw4news.presentation.models.News

class NewsSharedViewModel(private val repository: NewsRepository) : ViewModel() {
    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> get() = _news

    private val _dataNews = MutableLiveData<List<News>>()
    val daoNews: LiveData<List<News>> get() = _dataNews

    fun onNewsItemClicked(position: Int) {
        val item = _news.value?.get(position) ?: return
        val list = _news.value?.toMutableList() ?: return
        list[position] = item.copy(isChecked = !item.isChecked)
        _news.value = list
    }

    fun loadNetworkNews() {
        viewModelScope.launch {
            _news.value = repository.getNetworkNews()
        }
    }

    fun saveNews(news: News) {
        viewModelScope.launch {
            repository.insertDataNews(news)
        }
    }

    fun loadDataNews() {
        viewModelScope.launch {
            _dataNews.value = repository.getDataNews()
        }
    }

    fun deleteDataNews(news: News) {
        viewModelScope.launch {
            repository.deleteDataNews(news)
        }
    }
}