package selitskiyapp.hometasks.hw4news.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import selitskiyapp.hometasks.hw4news.domain.NewsInteractor
import selitskiyapp.hometasks.hw4news.network.Article

class NewsViewModel(private val interactor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> get() = _news

    init {
        loadNews()
    }

    fun onNewsItemClicked(position: Int) {
        val item = _news.value?.get(position) ?: return
        val list = _news.value?.toMutableList() ?: return
        list[position] = item.copy(isChecked = !item.isChecked)
        _news.value = list
    }

    private fun loadNews() {
        viewModelScope.launch {
//            _news.value = listOf(interactor.getNews())
        }
    }
}