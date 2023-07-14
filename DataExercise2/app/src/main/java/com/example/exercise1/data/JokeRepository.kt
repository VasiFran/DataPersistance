package com.example.exercise1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeRepository(private val jokeApi: JokeApi) {

    suspend fun listJokes(type: String) = jokeApi.listJokes(type)
}