package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.network.NewsApi
import selitskiyapp.hometasks.hw4news.network.NewsResponse

class NewsInteractorImpl(private val newsApi: NewsApi) : NewsInteractor {
    override suspend fun getNews(): NewsResponse {
        return newsApi.getEverything(
            query = "Политика",
            fromDate = null,
            toDate = null,
            language = "ru",
            sortBy = ""
        )
    }
}