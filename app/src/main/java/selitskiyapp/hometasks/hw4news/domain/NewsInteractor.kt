package selitskiyapp.hometasks.hw4news.domain

import androidx.lifecycle.LiveData
import selitskiyapp.hometasks.hw4news.data.dao.NewsEntity
import selitskiyapp.hometasks.hw4news.data.network.NewsResponse
import selitskiyapp.hometasks.hw4news.presentation.objects.News

interface NewsInteractor {
    suspend fun getNetworkNews() : List<News>
    
    suspend fun getDataNews(): List<News>

    fun getDataLiveNews(): LiveData<List<News>>

    suspend fun insertDataNews(news: News)
    
    suspend fun deleteDataNews(title: String?)
}