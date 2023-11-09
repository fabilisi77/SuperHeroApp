package com.example.superheroapp.data.remote

import com.example.superheroapp.data.model.SuperHeroList
import com.example.superheroapp.repository.WebService

class SuperHeroDataSource(private val webService: WebService) {
    suspend fun getSuperHero(superHeroName: String): SuperHeroList {
        return webService.getSuperHero(superHeroName)
    }
}