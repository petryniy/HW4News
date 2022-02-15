package selitskiyapp.hometasks.hw4news.data

import selitskiyapp.hometasks.hw4news.data.models.NewsEntity
import selitskiyapp.hometasks.hw4news.data.models.Articles
import selitskiyapp.hometasks.hw4news.presentation.models.News

fun NewsEntity.toNews() =
        News(
            title = title,
            urlToImage = urlToImage,

            isChecked = true
        )

fun News.toNewsEntity() =
        NewsEntity(
            title = title,
            urlToImage = urlToImage,
        )

fun Articles.toNews() =
        News(
            title = title,
            urlToImage = urlToImage,
        )
