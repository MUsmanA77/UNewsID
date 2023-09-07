package com.creadle.unewsid

var newsList = mutableListOf<News>()

var NEWS_EXTRA = "news_extra"

data class News (
    val photo: Int,
    val name: String,
    var description: String,
    val id: Int? = newsList.size
)