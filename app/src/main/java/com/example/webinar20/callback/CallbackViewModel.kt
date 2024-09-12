package com.example.webinar20.callback

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import kotlin.coroutines.resume

class CallbackViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openbrewerydb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(Api::class.java)

    // Coroutine function using suspendCancellableCoroutine

    suspend fun fetchDataWithRetrofit(param: String): Result {
        return suspendCancellableCoroutine { continuation ->
            // Call your Retrofit API function
            val call: Call<ApiResponse> = api.fetchBreweryData(param)

            // Cancel the Retrofit call if the coroutine is cancelled
            continuation.invokeOnCancellation {
                call.cancel()
            }

            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        continuation.resume(Result.Ok(response.body()!!))
                    } else {
                        continuation.resume(
                            Result.Error.Backend(
                                call.request().url().toString(),
                                response.code(),
                                IOException()
                            )
                        ) // TODO
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    if (t is CancellationException) {
                        /*nothing*/
                    } else {
                        continuation.resume(
                            Result.Error.Network(
                                call.request().url().toString(),
                                t
                            )
                        )
                    }
                }

            })

        }
    }


}