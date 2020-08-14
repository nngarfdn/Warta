package com.udindev.warta.network

import com.udindev.warta.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsService {

    @GET("v2/top-headlines?country=id&apiKey=9768f48a22d5466994aad0ce84ac7688")
    fun getTopNews(): Call<News>

    @GET("v2/top-headlines?country=id&category=sports&apiKey=9768f48a22d5466994aad0ce84ac7688")
    fun getSportNews() : Call<News>

    @GET("v2/top-headlines?country=id&category=business&apiKey=9768f48a22d5466994aad0ce84ac7688")
    fun getBussinesNews() : Call<News>

}