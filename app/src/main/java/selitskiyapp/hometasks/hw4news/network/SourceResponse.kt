package selitskiyapp.hometasks.hw4news.network

import com.google.gson.annotations.SerializedName

data class SourceResponce(
    @SerializedName("status")
    val status: String?,
    @SerializedName("sources")
    val sources: List<Source>
)

data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("category")
    val category: String?,
    @SerializedName("language")
    val lang: String?,
    @SerializedName("country")
    val country: String?
)
