package com.example.lesson_8.impl

import com.example.lesson_8.domain.GithubApi
import com.example.lesson_8.domain.Repository
import com.example.lesson_8.domain.entities.GithubUser

class RepositoryImpl(
    private val webApi: GithubApi
) : Repository {
    override suspend fun getUsers(): List<GithubUser> {
        return webApi.usersList()
    }
}