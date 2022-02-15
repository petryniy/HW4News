package selitskiyapp.hometasks.hw4news.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import selitskiyapp.hometasks.hw4news.data.models.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT*FROM news")
    suspend fun getAll(): List<NewsEntity>

    @Insert
    suspend fun insertNews(news: NewsEntity)

    @Delete
    suspend fun deleteNews(news: NewsEntity)

}