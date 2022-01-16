package selitskiyapp.hometasks.hw4news.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import selitskiyapp.hometasks.hw4news.data.dao.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT*FROM news")
    fun getAll(): List<NewsEntity>

    @Insert
    fun insertNews(news: NewsEntity)

    @Delete
    fun deleteNews(newsEntity: NewsEntity)
}