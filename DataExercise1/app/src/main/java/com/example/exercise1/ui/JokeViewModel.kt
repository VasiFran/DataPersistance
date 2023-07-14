package com.example.exercise1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise1.domain.models.Joke
import com.example.exercise1.data.JokeRepository
import com.example.exercise1.domain.usecase.ListJokesUseCase
import kotlinx.coroutines.launch

class JokeViewModel(private val listJokesUseCase: ListJokesUseCase) : ViewModel(){

    private val _jokeLiveData = MutableLiveData<List<Joke>>()
    val jokeLiveData: LiveData<List<Joke>> = _jokeLiveData

    fun tellJoke() {
        viewModelScope.launch {
            val jokes = listJokesUseCase("programming")
            _jokeLiveData.postValue(jokes)
        }
    }
}