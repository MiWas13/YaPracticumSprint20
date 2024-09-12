package com.example.webinar20.coroutines_usage_example.domain

class SomeUseCase(private val repository: SomeRepository) {
    suspend operator fun invoke() = repository.goToServer()
}