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
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

@Service
class OrderService (


) {
    //공통모듈로 써야하는가
    fun requestJsonPostToHttpUrlConnection(request: Menu, urlFlag : String) : String? {

        val url = "http://localhost:8082/"
        val urlConn = URL(url + urlFlag)
        val gson = Gson()
        val jsonString = gson.toJson(request)
        println(jsonString.toString())
        val sb = StringBuilder()
        val request_data = StringBuilder()

        request_data.append("coffeeDivCd").append("=").append(request.coffeeDivCd)
        println(request_data)
        val huc = urlConn.openConnection() as HttpURLConnection

        huc.requestMethod = "POST"
        huc.doOutput = true
        huc.setRequestProperty("Content-Type", "application/json")
        huc.setRequestProperty("Accept","application/json")
        huc.setRequestProperty("Accept-Language","UTF-8")

        huc.useCaches = false

        val write = OutputStreamWriter(huc.outputStream)
        write.write(request_data.toString())
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