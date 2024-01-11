package com.jay.backend.hub.controller

import com.google.gson.Gson
import com.jay.backend.hub.dto.Menu
import com.jay.backend.hub.service.OrderService
import org.springframework.web.bind.annotation.*

/*
* 허브 컨트롤러
* 요청 들어오는거 분개하는 컨트롤러
* 컨트롤러는 3개로 나누고 어차피 서버는 한대니까
* 큼직한 컨트롤러에서 WHEN으로 분개하기
* 작성인 : 박재형
* 기능 하나에 하나만 구현되도록 수정한다.
* */
@RestController
@RequestMapping("/API")
class OrderController () {

    @PostMapping("/menu")
    fun menu (@RequestBody(required = false) requestBody : HashMap<String, String>) : String? {
        return OrderService().menuRequest(requestBody)
    }
}