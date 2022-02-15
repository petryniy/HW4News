package selitskiyapp.hometasks.hw4news.domain

import androidx.lifecycle.LiveData
import selitskiyapp.hometasks.hw4news.presentation.models.News

interface NewsRepository {
    suspend fun getNetworkNews(): List<News>

    suspend fun getDataNews(): List<News>

    suspend fun insertDataNews(news: News)

    suspend fun deleteDataNews(news: News)
}