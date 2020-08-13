package com.udindev.warta.network

import com.udindev.warta.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    private val service: NewsService

    companion object {
        const val BASE_URL = "https://newsapi.org/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(NewsService::class.java)
    }

    fun getResultsTopNews(): Call<News> {
        return service.getTopNews()
    }
}