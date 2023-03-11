package com.jay.backend.hub.service

import com.google.gson.JsonObject
import org.springframework.stereotype.Service

@Service
class OrderService {
    fun callBrand(): JsonObject{

        var json = JsonObject()
        //여기서 브랜드 목록을 가져오는 Call 요청하기
        var returnData : JsonObject = json.getAsJsonObject("")

        return returnData
    }
}