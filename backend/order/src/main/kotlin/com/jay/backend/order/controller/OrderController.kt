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
* order controller
* 우선 컨트롤러단에 소스 때려박고서 서비스로 이관하는 작업 진행
* */
@RestController
class OrderController {

    @PostMapping("/menu")
    fun order () : String{

        return "call_menu_controller"
    }
}