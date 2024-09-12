package com.example.webinar20.flow_usage_example.domain

class FlowUsageUseCase(private val repository: FlowUsageRepository) {
    suspend operator fun invoke() = repository.goToServer()
}