package selitskiyapp.hometasks.hw4news.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import selitskiyapp.hometasks.hw4news.data.dao.NewsDao
import selitskiyapp.hometasks.hw4news.data.models.NewsResponse
import selitskiyapp.hometasks.hw4news.data.network.NewsApi
import selitskiyapp.hometasks.hw4news.domain.NewsRepository
import selitskiyapp.hometasks.hw4news.presentation.models.News

class NewsRepositoryImpl(
    private val newsDao: NewsDao,
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getNetworkNews(): List<News> {
        return withContext(Dispatchers.IO) {
            downloadNetworkNews().articles.map { articles ->
                articles.toNews()
            }
        }
    }

    override suspend fun getDataNews(): List<News> {
        return withContext(Dispatchers.IO) {
            newsDao.getAll().map { newsEntity ->
                newsEntity.toNews()
            }
        }
    }

    override suspend fun insertDataNews(news: News) {
         withContext(Dispatchers.IO) {
            newsDao.insertNews(news.toNewsEntity())
        }
    }

    override suspend fun deleteDataNews(news: News) {
        newsDao.deleteNews(news.toNewsEntity())
    }

    private suspend fun downloadNetworkNews(): NewsResponse {
        return newsApi.getEverything(
            query = "",
            fromDate = null,
            toDate = null,
            language = "ru",
            sortBy = ""
        )
    }
}

