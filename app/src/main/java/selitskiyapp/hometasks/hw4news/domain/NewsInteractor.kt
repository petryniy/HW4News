package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.data.network.NewsResponse
import selitskiyapp.hometasks.hw4news.presentation.objects.News

interface NewsInteractor {
    suspend fun getNetworkNews() : List<News>
    
    suspend fun getDataNews(): List<News>
    
    suspend fun insertDataNews(list: List<News>)
    
    suspend fun deleteDataNews(title: String)
}