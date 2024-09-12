package com.example.webinar20.flow_usage_example.domain

import kotlinx.coroutines.flow.Flow

interface FlowUsageRepository {
    suspend fun goToServer(): Flow<String>
}