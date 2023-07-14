package com.example.exercise1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependencyInjection {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://official-joke-api.appspot.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val jokeApi = retrofit.create(JokeApi::class.java)

    val jokeRepository = JokeRepository(jokeApi)
}