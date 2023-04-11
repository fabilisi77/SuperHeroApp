package com.example.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image") val imageDetail:ImageDetailSuperHero,
    @SerializedName("powerstats") val powerstats: SuperHeroPowerStatsResponse
) {

}

data class SuperHeroPowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class ImageDetailSuperHero(@SerializedName("url") val urlImage:String)

