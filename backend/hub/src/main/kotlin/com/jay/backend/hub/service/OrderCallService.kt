package com.jay.backend.hub.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.jay.backend.hub.dto.Menu
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service

@Service
class OrderCallService (
    private val okHttpClient: OkHttpClient,
    private val objectMapper: ObjectMapper
){
    fun requestJsonPost(request: Menu, urlFlag : String) : String? {
        val requestBody = objectMapper.writeValueAsString(request)
        println(requestBody.toRequestBody("application/json; charset=utf-8".toMediaType()))
        val httpResponse =
            okHttpClient.newCall(
                Request.Builder()
                    .url("http://localhost:8082/" + urlFlag)
                    .post(requestBody.toRequestBody("application/json; charset=utf-8".toMediaType()))
                    .build()
            ).execute()

        val responseBody : String? = httpResponse.body?.string()

        println(responseBody)

        return responseBody
    }
}