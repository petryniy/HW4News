package selitskiyapp.hometasks.hw4news.data.network

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("resultNumber")
    val resultNumber: Double?,
    @SerializedName("articles")
    val articles: List<Articles>
)

data class Articles(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val articleUrl: String?,
    @SerializedName("urlToImage")
    val previewUrl: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?,

    val isChecked: Boolean = false
)


