package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.network.NewsResponse

interface NewsInteractor {
    suspend fun getNews(): NewsResponse
}