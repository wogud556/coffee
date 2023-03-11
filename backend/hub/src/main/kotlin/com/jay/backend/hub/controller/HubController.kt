package com.jay.backend.hub.controller

import com.google.gson.JsonObject
import com.jay.backend.hub.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/*
* 허브 컨트롤러
* 요청 들어오는거 분개하는 컨트롤러
* 컨트롤러는 3개로 나누고 어차피 서버는 한대니까
* 큼직한 컨트롤러에서 WHEN으로 분개하기
* 작성인 : 박재형
* */
@RestController
class HubController {

    @PostMapping("/API/order")
    fun order () : String{
        //구분코드
        var downChannel : String? = null;

        when(downChannel){

        }

        return "orderChannel"
    }

    //사용자 정보 요청 시 그리고 로그인관련
    @PostMapping("/API/user")
    fun user () : String{
        //구분코드
        var downChannel : String? = null;

        when(downChannel){
            "login" -> ""
        }

        return "hello"
    }

    //이벤트 목록 요청 혹은 이벤트 참여 관련 데이터 적재
    @PostMapping("/API/event")
    fun event () : String{
        //구분코드
        var downChannel : String? = null;
        var eventService = EventService(downChannel)
        var returnData : JsonObject = JsonObject()

        /**/
        when(downChannel){
            //
            "reward" -> returnData = eventService.reward()
            "event" -> returnData = eventService.event()

        }

        return returnData.asString
    }
}