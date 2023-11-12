package com.example.tugas_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_retrofit.databinding.ActivityMainBinding
import com.example.tugas_retrofit.model.HeroData
import com.example.tugas_retrofit.model.HeroModel
import com.example.tugas_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var HeroList: ArrayList<ResultItem>
    private lateinit var rvhero: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        HeroList = arrayListOf<ResultItem>()

        with(binding) {
            val response = ApiClient.getInstance().getAllHeroModel()

            response.enqueue(object : Callback<HeroData> {
                override fun onResponse(call: Call<HeroData>, response: Response<HeroData>) {
                    val heroResponse = response.body()
                    val heros = heroResponse?.result
                    if (heros != null) {
                        for (i: HeroModel in heros) {
                            val hero = ResultItem(i.heroImage, i.id, i.heroName)
                            HeroList.add(hero)
                        }
                        rvhero = rvHero
                        val adapter = HeroAdapter(HeroList)
                        rvHero.adapter = adapter
                        rvHero.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }


                override fun onFailure(call: Call<HeroData>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity,
                        "Failed to retrieve data. Please check your internet connection.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // You can also log the error for debugging purposes
                    Log.e("MainActivity", "API call failed", t)
                }
            })
        }
    }

    }



