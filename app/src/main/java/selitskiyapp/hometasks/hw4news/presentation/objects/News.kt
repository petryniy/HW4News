package selitskiyapp.hometasks.hw4news.presentation.objects

data class News (
    val title : String?,
    val urlToImage: String?,

    val isChecked: Boolean = false
)