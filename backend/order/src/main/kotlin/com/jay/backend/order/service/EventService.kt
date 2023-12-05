package com.jay.backend.hub.service

import com.google.gson.JsonObject
import org.springframework.stereotype.Service


@Service
class EventService {

    /*
    * 상위 업무가 Event라는 것을 알고 있기 때문에 하위 업무 단위로 분개하게끔 진행
    * */
    constructor(downChannel:String?)

    fun reward() : JsonObject{
        var returnData : JsonObject = JsonObject()
        //reward 관련 call을 수행한다.
        return returnData
    }

    fun event() : JsonObject{
        //event 관련 call을 수행한다.
        //추가로 이벤트 추가시 이벤트 구분코드를 추가하여 어떤 이벤트 참여인지에 대한 여부를 확인할 필요가 있음
        var returnData : JsonObject = JsonObject()
        //reward 관련 call을 수행한다.
        return returnData
    }
}