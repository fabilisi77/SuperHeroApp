package com.example.superheroapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.superheroapp.core.Result
import com.example.superheroapp.repository.SuperHeroRepository
import kotlinx.coroutines.Dispatchers

class SuperHeroViewModel(private val repo: SuperHeroRepository) : ViewModel() {

    fun fetchSuperHeroById() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getSuperHero()))

        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class SuperHeroViewModelFactory(private val repo: SuperHeroRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SuperHeroRepository::class.java).newInstance(repo)
    }

}

