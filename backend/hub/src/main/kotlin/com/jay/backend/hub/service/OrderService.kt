package com.jay.backend.hub.service

import com.google.gson.JsonObject
import org.springframework.stereotype.Service

@Service
class OrderService {
    fun callBrand(): JsonObject{
        val url = URL("http://localhost:8081/menu")
        val connection = url.openConnection()

        connection.doOutput = true
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        connection.setRequestProperty("Content-Length", postData.length.toString())

        DataOutputStream(connection.getOutputStream()).use { it.writeBytes(postData) }
        BufferedReader(InputStreamReader(connection.getInputStream())).use{ bf ->
            val line: String?
            while(inp.readLine().also { line = it  != null}) {
                println(line)
            }
        }
        var json = JsonObject()
        //여기서 브랜드 목록을 가져오는 Call 요청하기
        var returnData : JsonObject = json.getAsJsonObject("")

        return returnData
    }
}