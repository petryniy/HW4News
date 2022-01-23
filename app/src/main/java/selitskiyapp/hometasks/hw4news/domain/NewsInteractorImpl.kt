package selitskiyapp.hometasks.hw4news.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
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

    override fun getDataLiveNews(): LiveData<List<News>> {
        return newsDao.getAllLiveData().map { list ->
            list.map { newsEntity -> newsEntity.toNews() }
        }
    }

    override suspend fun insertDataNews(news: News) {
        return withContext(Dispatchers.IO) {
            newsDao.insertNews(news.toNewsEntity())
        }
    }

    override suspend fun deleteDataNews(title: String?) {
        withContext(Dispatchers.IO) {
            newsDao.deleteNews(title)
        }
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

