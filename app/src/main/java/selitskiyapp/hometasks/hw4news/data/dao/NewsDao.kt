package selitskiyapp.hometasks.hw4news.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import selitskiyapp.hometasks.hw4news.presentation.objects.News

@Dao
interface NewsDao {
    @Query("SELECT*FROM news")
    fun getAll(): List<NewsEntity>

    @Query("SELECT*FROM news")
    fun getAllLiveData(): LiveData<List<NewsEntity>>

    @Insert
    fun insertNews(news: NewsEntity)

    @Query("DELETE FROM news WHERE title = :title")
    fun deleteNews(title: String?)
}