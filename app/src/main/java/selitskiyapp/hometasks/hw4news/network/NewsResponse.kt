package selitskiyapp.hometasks.hw4news.network

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("resultNumber")
    val resultNumber: Long?,
    @SerializedName("articles")
    val articles: List<Article>
)

data class Article(
    @SerializedName("source")
    val source : Source,
    @SerializedName("title")
    val title : String?,
    @SerializedName("url")
    val url: String,

    val isChecked: Boolean = false
)


