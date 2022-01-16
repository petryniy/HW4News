package selitskiyapp.hometasks.hw4news.domain

import selitskiyapp.hometasks.hw4news.data.dao.NewsEntity
import selitskiyapp.hometasks.hw4news.data.network.Articles
import selitskiyapp.hometasks.hw4news.presentation.objects.News

fun NewsEntity.toNews() =
//    source?.let {
        News(
//            source = it,
            title = title,
            urlToImage = urlToImage,

            isChecked = isChecked
        )
//    }

fun News.toNewsEntity() =
//    source?.let {
        NewsEntity(
//            source = it,
            title = title,
            urlToImage = urlToImage,

            isChecked = isChecked
        )
//    }

fun Articles.toNews() =
//    source?.let {
        News(
//            source = it,
            title = title,
            urlToImage = previewUrl,

            isChecked = isChecked
        )
//    }
