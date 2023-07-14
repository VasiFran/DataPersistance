package com.example.exercise1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exercise1.domain.DomainDependencyInjection

class JokeViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val listJokesUseCase = DomainDependencyInjection.listJokesUseCase
        return JokeViewModel(listJokesUseCase) as T
    }
}