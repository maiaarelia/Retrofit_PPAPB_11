package com.example.tugas_retrofit.network

import com.example.tugas_retrofit.model.HeroData
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import com.example.tugas_retrofit.model.HeroModel
import okhttp3.ResponseBody

interface ApiService {
    @GET("data.php")
    fun getAllHeroModel(): Call<HeroData>
}