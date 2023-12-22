package com.example.xvouch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name: String,
    val dev: String,
    val price: String,
    val photo: Int,
    val mainImageDetail: Int
): Parcelable
