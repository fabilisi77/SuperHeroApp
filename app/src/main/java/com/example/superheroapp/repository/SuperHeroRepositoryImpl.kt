package com.example.superheroapp.repository

import com.example.superheroapp.data.model.SuperHeroList
import com.example.superheroapp.data.remote.SuperHeroDataSource

class SuperHeroRepositoryImpl(private val dataSource: SuperHeroDataSource) : SuperHeroRepository {

    override suspend fun getSuperHero(superHeroName: String): SuperHeroList {
        return dataSource.getSuperHero(superHeroName)
    }
}