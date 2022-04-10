package com.example.lesson_8.domain.entities

import com.google.gson.annotations.SerializedName

data class GithubUser(
    @SerializedName("login") var login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("type") val type: String
)
