package com.example.superheroapp.repository

import com.example.superheroapp.data.model.SuperHeroList

interface SuperHeroRepository {
    suspend fun getSuperHero(superHeroName: String): SuperHeroList
}