package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.data.dao.NewsEntity
import selitskiyapp.hometasks.hw4news.data.network.Articles
import selitskiyapp.hometasks.hw4news.presentation.objects.News

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
