package com.example.tugas_retrofit

import com.google.gson.annotations.SerializedName


data class ResultItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val heroName: String? = null
)
