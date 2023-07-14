package com.example.exercise1.domain.usecase

import com.example.exercise1.data.JokeRepository

class ListJokesUseCase (private val jokeRepository: JokeRepository){

    suspend operator fun invoke (type: String) = jokeRepository.listJokes(type)
}