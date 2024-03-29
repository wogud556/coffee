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
    fun menuRequest(request : HashMap<String, String>) : String? {
        val parseRequest = Gson()
        val menu = Menu(request.get("coffeeDivCd"), request.get("filter"))
        val request_data = StringBuilder()
        val urlFlag = request.get("urlFlag")
        val url = "http://localhost:8082/"

        val urlConn = URL(url + urlFlag)
        val gson = Gson()

        val jsonString = gson.toJson(menu)
        println(jsonString.toString())
        val sb = StringBuilder()

        val huc = urlConn.openConnection() as HttpURLConnection

        huc.requestMethod = "POST"
        huc.doOutput = true
        huc.doInput = true

        huc.setRequestProperty("Content-Type", "application/json")
        huc.setRequestProperty("Accept","application/json")
        huc.setRequestProperty("Accept-charset","UTF-8")

        huc.useCaches = false

        val write = OutputStreamWriter(huc.outputStream)
        write.write(jsonString)
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