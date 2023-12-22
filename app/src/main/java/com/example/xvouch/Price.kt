package com.example.xvouch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Price(
    val dmAmount: String,
    val dmPrice: String
) : Parcelable
