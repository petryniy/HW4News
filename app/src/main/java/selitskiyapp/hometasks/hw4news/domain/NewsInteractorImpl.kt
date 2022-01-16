package selitskiyapp.hometasks.hw4news.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import selitskiyapp.hometasks.hw4news.data.dao.NewsDao
import selitskiyapp.hometasks.hw4news.data.network.NewsApi
import selitskiyapp.hometasks.hw4news.data.network.NewsResponse
import selitskiyapp.hometasks.hw4news.presentation.objects.News

class NewsInteractorImpl(
    private val newsDao: NewsDao,
    private val newsApi: NewsApi
) : NewsInteractor {
    override suspend fun getNetworkNews(): List<News> {
        return withContext(Dispatchers.IO) {
            insertNetworkNews().articles.map { articles -> articles.toNews() }
        }
    }

    override suspend fun getDataNews(): List<News> {
        return withContext(Dispatchers.IO) {
            newsDao.getAll().map { newsEntity -> newsEntity.toNews() }
        }
    }

    override suspend fun insertDataNews(list: List<News>) {
        return withContext(Dispatchers.IO) {
            list.map { daoNews -> daoNews.toNewsEntity() }
                .forEach { newsEntity -> newsDao.insertNews(newsEntity) }
        }
    }

    override suspend fun deleteDataNews(title: String) {
        TODO("Not yet implemented")
    }

    private suspend fun insertNetworkNews(): NewsResponse {
        return newsApi.getEverything(
            query = "",
            fromDate = null,
            toDate = null,
            language = "ru",
            sortBy = ""
        )
    }
}

