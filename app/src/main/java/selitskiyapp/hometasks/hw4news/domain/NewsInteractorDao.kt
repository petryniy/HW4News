package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.presentation.objects.News

interface NewsInteractorDao {
    suspend fun loadNews(): List<News>

    suspend fun insertNews(list: List<News>)
}