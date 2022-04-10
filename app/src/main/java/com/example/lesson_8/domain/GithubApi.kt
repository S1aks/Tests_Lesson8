package com.example.lesson_8.domain

import com.example.lesson_8.domain.entities.GithubUser
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    suspend fun usersList(): List<GithubUser>
}