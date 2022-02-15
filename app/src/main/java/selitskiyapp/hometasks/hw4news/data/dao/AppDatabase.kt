package selitskiyapp.hometasks.hw4news.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import selitskiyapp.hometasks.hw4news.data.models.NewsEntity

@Database(
    entities = [
        NewsEntity::class
    ],
    version = AppDatabase.VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getNewsDao(): NewsDao
}