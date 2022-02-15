package selitskiyapp.hometasks.hw4news.presentation.models

data class News (
    val title : String?,
    val urlToImage: String?,

    val isChecked: Boolean = false
)