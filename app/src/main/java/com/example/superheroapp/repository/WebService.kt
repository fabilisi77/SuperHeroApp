package com.example.superheroapp.repository

import com.example.superheroapp.SuperHeroDetailResponse
import com.example.superheroapp.data.model.SuperHeroList
import com.example.superheroapp.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("/api/175327632044137/search/{name}")
    suspend fun getSuperHero(@Path("name") superHeroName: String): SuperHeroList

    @GET("/api/175327632044137/{id}")
    suspend fun getSuperHeroDetail(@Path("id") superHeroDetail: String): Response<SuperHeroDetailResponse>
}


object RetrofitClient {
    val webService by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(WebService::class.java)
    }
}