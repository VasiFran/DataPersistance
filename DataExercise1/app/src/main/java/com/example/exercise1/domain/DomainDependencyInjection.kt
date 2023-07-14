package com.example.exercise1.domain

import com.example.exercise1.data.DataDependencyInjection
import com.example.exercise1.domain.usecase.ListJokesUseCase

object DomainDependencyInjection {

    val listJokesUseCase = ListJokesUseCase(DataDependencyInjection.jokeRepository)
}