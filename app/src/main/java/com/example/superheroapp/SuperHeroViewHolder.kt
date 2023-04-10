package com.example.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (view:View):RecyclerView.ViewHolder(view){
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroListResponse: SuperHeroListResponse){
        binding.tvName.text = superHeroListResponse.name

    }

}