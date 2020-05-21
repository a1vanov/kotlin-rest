package ru.gpn.kr.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
        val id: Long,
        val name: String,
        val email: String,
        val phone: String,
        val company: UserCompany
)

@Serializable
data class Geo(
        val lat: String,
        val lng: String
)

@Serializable
data class UserCompany(
        val name: String
)