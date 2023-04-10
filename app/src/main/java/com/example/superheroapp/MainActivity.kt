package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.example.superheroapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

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
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperHero(query)

            val response: SuperHeroDataResponse? = myResponse.body()
            if (response != null) {
                Log.i("Comprobation", response.toString())
            }

            if (myResponse.isSuccessful) {
                Log.i("Comprobation", "Is Ready man!")
            } else {
                Log.i("Comprobation", "ERROR!!!")
            }

        }

    }


}

private fun getRetrofit(): Retrofit {

    return Retrofit
        .Builder()
        .baseUrl("https://superheroapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}


//Key: 175327632044137