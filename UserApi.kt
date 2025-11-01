package com.example.api

import retrofit2.http.GET

interface UserApi {
    @GET("user")
    suspend fun getUser(): UserDto
}
