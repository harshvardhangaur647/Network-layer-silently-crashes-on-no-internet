package com.example.repository

import com.example.api.UserApi
import com.example.network.NetworkResult
import com.example.network.safeApiCall

class UserRepository(
    private val api: UserApi
) {
    suspend fun fetchUser(): NetworkResult<String> {
        return safeApiCall {
            val user = api.getUser()
            user.name
        }
    }
}
