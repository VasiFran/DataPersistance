package com.example.exercise1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise1.data.Joke
import com.example.exercise1.network.JokeApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeViewModel : ViewModel() {

    private var jokeApi: JokeApi

    val jokeLiveData = MutableLiveData<List<Joke>>()

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        jokeApi = retrofit.create(JokeApi::class.java)
    }

    fun tellJoke() {
        viewModelScope.launch {
            val jokes = jokeApi.listJokes("programming")
            jokeLiveData.postValue(jokes)
        }
    }
}