package com.example.project1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodTruck(
    var id: Int,
    var name: String,
    var img: Int,
    var location: String,
    var time: String,
    var description: String,
    var link: String
):Parcelable
