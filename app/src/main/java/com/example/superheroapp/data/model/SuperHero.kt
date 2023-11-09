package com.example.superheroapp.data.model

import com.google.gson.annotations.SerializedName

data class SuperHeroList(
    @SerializedName("results") val results: List<SuperHero> = listOf()
)

data class SuperHero(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperHeroImageResponse
)
data class SuperHeroImageResponse(@SerializedName("url") val url: String)
