package com.example.exercise1.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise1.domain.models.Joke
import com.example.exercise1.domain.usecase.ListJokesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class JokeViewModel(private val listJokesUseCase: ListJokesUseCase) : ViewModel(){

    val jokeLiveData = MutableSharedFlow<List<Joke>>()

    fun tellJoke() {
        viewModelScope.launch {
            val jokes = listJokesUseCase("programming")
            jokeLiveData.emit(jokes)
        }
    }
}