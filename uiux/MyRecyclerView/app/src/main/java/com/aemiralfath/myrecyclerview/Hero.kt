package com.aemiralfath.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
): Parcelable