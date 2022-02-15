package selitskiyapp.hometasks.hw4news.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import selitskiyapp.hometasks.hw4news.data.dao.NewsDao
import selitskiyapp.hometasks.hw4news.data.models.NewsEntity
import selitskiyapp.hometasks.hw4news.domain.NewsRepository
import selitskiyapp.hometasks.hw4news.presentation.models.News

class NewsDaoViewModel(
    private val repository: NewsRepository,
    private val newsDao: NewsDao
) : ViewModel() {

//    fun onNewsItemClicked(position: Int) {
//        val item = _dataNews.value?.get(position) ?: return
//        val list = _dataNews.value?.toMutableList() ?: return
//        list[position] = item.copy(isChecked = !item.isChecked)
//        _dataNews.value = list
//    }
}