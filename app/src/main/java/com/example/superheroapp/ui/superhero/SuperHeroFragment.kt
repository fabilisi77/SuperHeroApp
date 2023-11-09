package com.example.superheroapp.ui.superhero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.superheroapp.R
import com.example.superheroapp.data.remote.SuperHeroDataSource
import com.example.superheroapp.databinding.FragmentSuperHeroBinding
import com.example.superheroapp.presentation.SuperHeroViewModel
import com.example.superheroapp.presentation.SuperHeroViewModelFactory
import com.example.superheroapp.repository.RetrofitClient
import com.example.superheroapp.repository.SuperHeroRepositoryImpl

class SuperHeroFragment : Fragment(R.layout.fragment_super_hero) {
private lateinit var binding: FragmentSuperHeroBinding
private val viewModel by viewModels<SuperHeroViewModel> {SuperHeroViewModelFactory(SuperHeroRepositoryImpl(
    SuperHeroDataSource(RetrofitClient.webService)
))  }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}