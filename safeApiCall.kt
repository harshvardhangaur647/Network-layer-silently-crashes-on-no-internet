package com.example.network

import java.io.IOException

suspend fun <T> safeApiCall(call: suspend () -> T): NetworkResult<T> {
    return try {
        val result = call()
        NetworkResult.Success(result)
    } catch (e: IOException) {
        NetworkResult.Offline
    } catch (e: Exception) {
        NetworkResult.Error(e.message ?: "Unknown error")
    }
}
