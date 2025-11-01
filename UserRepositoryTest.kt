package com.example.repository

import com.example.api.UserApi
import com.example.api.UserDto
import com.example.network.NetworkResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.io.IOException

class UserRepositoryTest {

    @Test
    fun `test success response`() = runBlocking {
        val fakeApi = object : UserApi {
            override suspend fun getUser() = UserDto("1", "Harsh")
        }

        val repo = UserRepository(fakeApi)
        val result = repo.fetchUser()

        assertTrue(result is NetworkResult.Success)
        assertEquals("Harsh", (result as NetworkResult.Success).data)
    }

    @Test
    fun `test offline error`() = runBlocking {
        val fakeApi = object : UserApi {
            override suspend fun getUser(): UserDto {
                throw IOException("No Internet")
            }
        }

        val repo = UserRepository(fakeApi)
        val result = repo.fetchUser()

        assertTrue(result is NetworkResult.Offline)
    }

    @Test
    fun `test unknown exception`() = runBlocking {
        val fakeApi = object : UserApi {
            override suspend fun getUser(): UserDto {
                throw RuntimeException("Server Down")
            }
        }

        val repo = UserRepository(fakeApi)
        val result = repo.fetchUser()

        assertTrue(result is NetworkResult.Error)
        assertEquals("Server Down", (result as NetworkResult.Error).message)
    }
}
