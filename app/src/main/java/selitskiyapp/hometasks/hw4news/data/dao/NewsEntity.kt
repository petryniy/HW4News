package selitskiyapp.hometasks.hw4news.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import selitskiyapp.hometasks.hw4news.data.network.Source

@Entity(tableName = "news")
data class NewsEntity(
//    @ColumnInfo(name = "source")
//    val source: Source?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?,

    @ColumnInfo(name = "isChecked")
    val isChecked: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


