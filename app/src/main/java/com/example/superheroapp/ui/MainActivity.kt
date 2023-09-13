package com.example.superheroapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.DetailSuperHero
import com.example.superheroapp.DetailSuperHero.Companion.EXTRA_ID
import com.example.superheroapp.ui.superhero.adapter.SuperHeroAdapter
import com.example.superheroapp.SuperHeroDataResponse
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.repository.ApiService
import com.example.superheroapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //esta funcion se va a llamar cada vez que pulsemos en el boton de buscar

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            //esta funcion se va a llamar cada vez que vayamos escribiendo
            override fun onQueryTextChange(newText: String?): Boolean {
                return false//Siempre se retorna un "false"
            }

        })

        adapter = SuperHeroAdapter { navigateToDetail(it) }
        binding.rvSuperHeroList.setHasFixedSize(true)
        binding.rvSuperHeroList.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHeroList.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperHero(query)

            val response: SuperHeroDataResponse? = myResponse.body()
            if (response != null) {
                Log.i("Comprobation", response.toString())

                runOnUiThread {
                    adapter.updateList(response.results)
                    binding.progressBar.isVisible = false
                }


            }

            if (myResponse.isSuccessful) {
                Log.i("Comprobation", "Is Ready man!")
            } else {
                Log.i("Comprobation", "ERROR!!!")
            }

        }

    }

    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperHero::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }


}


//Key: 175327632044137
