package com.jay.backend.hub.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.jay.backend.hub.dto.Menu
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

@Service
class OrderCallService (

){
//    fun requestJsonPost(request: Menu, urlFlag : String) : String? {
//        val requestBody = objectMapper.writeValueAsString(request)
//        val url = "http://localhost:8082/"
//        println(requestBody.toRequestBody("application/json; charset=utf-8".toMediaType()))
//        val httpResponse =
//            okHttpClient.newCall(
//                Request.Builder()
//                    .url(url + urlFlag)
//                    .post(requestBody.toRequestBody("application/json; charset=utf-8".toMediaType()))
//                    .build()
//            ).execute()
//
//        val responseBody : ArrayList<String> = objectMapper.readValue(httpResponse.body?.toString() ,ArrayList<String?>())
//
//        println(responseBody)
//
//        return responseBody
//    }
    fun requestJsonPostToHttpUrlConnection(request: Menu, urlFlag : String) : String? {

        val url = "http://localhost:8082/"
        val urlConn = URL(url + urlFlag)
        val gson = Gson()
        var jsonString = gson.toJson(request)
        val sb = StringBuilder()
        val huc = urlConn.openConnection() as HttpURLConnection

        println(jsonString)
        huc.requestMethod = "POST"
        huc.doOutput = true
        huc.setRequestProperty("Content-Type", "application/json")
        huc.setRequestProperty("Accept","application/json")
        huc.useCaches = false

        val write = DataOutputStream(huc.outputStream)
        write.writeBytes(jsonString)
        write.flush()
        write.close()
        val responseCode = huc.responseCode
        if(responseCode == HttpURLConnection.HTTP_OK) {
            val returnText = huc.inputStream.bufferedReader().use(BufferedReader::readText)
            sb.append(returnText)
        }
        huc.disconnect()
        return sb.toString()
    }
}