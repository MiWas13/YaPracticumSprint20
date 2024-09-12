package com.example.webinar20.coroutines_usage_example.data

import android.util.Log
import com.example.webinar20.coroutines_usage_example.domain.SomeRepository

class SomeRepositoryImpl : SomeRepository {
    override suspend fun goToServer() {
        Log.e("YEAH", "Request!")
    }
}