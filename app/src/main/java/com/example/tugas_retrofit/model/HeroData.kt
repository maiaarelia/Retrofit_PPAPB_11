package com.example.tugas_retrofit.model

import com.google.gson.annotations.SerializedName

data class HeroData(
    @SerializedName("result")
    val result: List<HeroModel>
)
