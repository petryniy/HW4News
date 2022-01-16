package selitskiyapp.hometasks.hw4news.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        NewsEntity::class
    ],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getNewsDao(): NewsDao
}