package com.example.tugas_retrofit.model

import com.google.gson.annotations.SerializedName

data class HeroModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val heroName: String,
    @SerializedName("image")
    val heroImage: String
)


