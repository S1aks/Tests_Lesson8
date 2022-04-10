package com.example.lesson_8.domain

import com.example.lesson_8.domain.entities.GithubUser

interface Repository {
    suspend fun getUsers(): List<GithubUser>
}