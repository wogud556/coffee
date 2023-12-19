package com.jay.backend.hub.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.jay.backend.hub.dto.Menu
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service

@Service
class OrderService (


) {
    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val objectMapper: ObjectMapper = ObjectMapper()
    fun requestJsonPost(request: Menu, flag : String) : String {
        val requestBody = objectMapper.writeValueAsString(request)

        val httpResponse = okHttpClient.newCall(
                Request.Builder()
                    .url("http://localhost:8082/" + flag)
                    .post(requestBody.toRequestBody("application/json; charset=utf-8".toMediaType()))
                    .build()
            ).execute()


        val statusCode : Int = httpResponse.code
        val responseBody: String ? = httpResponse.body?.string()

        val response = objectMapper.readValue(responseBody, Menu::class.java)

        return response.toString()
    }
}