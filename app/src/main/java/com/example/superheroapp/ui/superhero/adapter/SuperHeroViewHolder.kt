package com.example.superheroapp.ui.superhero.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.SuperHeroList
import com.example.superheroapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroListResponse: SuperHeroList, onItemSelected: (String) -> Unit) {
        binding.tvName.text = superHeroListResponse.name
        Picasso.get().load(superHeroListResponse.image.url).into(binding.ivSuperHero)
        binding.root.setOnClickListener { onItemSelected(superHeroListResponse.id) }


    }

}