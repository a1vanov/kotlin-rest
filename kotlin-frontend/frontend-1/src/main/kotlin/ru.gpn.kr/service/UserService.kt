package ru.gpn.kr.service

import org.w3c.fetch.RequestInit
import ru.gpn.kr.model.User
import kotlin.browser.window
import kotlin.js.json
import kotlinx.coroutines.await
import kotlinx.serialization.json.Json

const val JSON_PLACEHOLDER_URL = "http://127.0.0.1:8080"

class UserService {

    suspend fun getUser(): User {
        val response = fetch("$JSON_PLACEHOLDER_URL/getUser")
        return Json.parse(User.serializer(), response)
    }

    private suspend fun fetch(url: String): String {
        val response = window.fetch(url, RequestInit("GET", headers = json(
                "Accept" to "application/json",
                "Content-Type" to "application/json"
        ))).await()

        return response.text().await()
    }
}