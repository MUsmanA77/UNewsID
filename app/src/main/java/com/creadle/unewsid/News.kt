package com.creadle.unewsid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

var newsList = mutableListOf<News>()

var NEWS_EXTRA = "news_extra"

@Parcelize
data class News(
    val photo: Int,
    val name: String,
    val description: String,
    val id: Int? = newsList.size
) : Parcelable