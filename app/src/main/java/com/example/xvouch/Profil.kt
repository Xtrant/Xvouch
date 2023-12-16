package com.example.xvouch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profil(
    val logo: Int,
    val judul: String,
    val isi: String
) : Parcelable
