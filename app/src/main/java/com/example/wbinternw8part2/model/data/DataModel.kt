package com.example.wbinternw8part2.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    val id: Int,
    val name: String,
    val powerstats: PowerStats,
    val images: Img
) : Parcelable {

    @Parcelize
    data class PowerStats(
        val intelligence: Int,
        val strength: Int,
        val speed: Int,
        val durability: Int,
        val power: Int,
        val combat: Int
    ) : Parcelable

    @Parcelize
    data class Img(
        val md: String,
    ) : Parcelable
}