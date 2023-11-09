package com.example.superheroapp.data.model

import com.example.superheroapp.SuperHeroImageResponse
import com.example.superheroapp.SuperHeroList
import com.google.gson.annotations.SerializedName

data class SuperHeroDetail(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperHeroList>
)

data class SuperHeroDetailList(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperHeroImageResponse
)
