package com.example.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/175327632044137/search/{name}")
    suspend fun getSuperHero(@Path("name") superHeroName: String): Response<SuperHeroDataResponse>
}
