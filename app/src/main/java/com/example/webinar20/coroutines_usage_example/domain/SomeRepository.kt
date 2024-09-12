package com.example.webinar20.coroutines_usage_example.domain

interface SomeRepository {
    suspend fun goToServer()
}