package com.jay.backend.hub.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class HubController {

    @PostMapping("/test")
    fun index () : String{

        return "hello"
    }

    @PostMapping("/hubtest")
    fun hub () : String{


        return "hello"
    }

}