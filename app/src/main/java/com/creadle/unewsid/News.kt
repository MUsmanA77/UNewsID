package com.creadle.unewsid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize




@Parcelize
data class News(
    val photo: Int,
    val name: String,
    val description: String,

) : Parcelable