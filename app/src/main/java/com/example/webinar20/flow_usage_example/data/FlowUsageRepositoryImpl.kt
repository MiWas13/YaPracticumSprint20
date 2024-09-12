package com.example.webinar20.flow_usage_example.data

import com.example.webinar20.flow_usage_example.domain.FlowUsageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FlowUsageRepositoryImpl : FlowUsageRepository {
    override suspend fun goToServer(): Flow<String> {
        return flowOf("Request from Flow!")
    }
}