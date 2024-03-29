package com.jay.backend.hub.controller

import com.google.gson.JsonObject
import com.jay.backend.hub.dto.UserResponse
import com.jay.backend.hub.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/*
* 허브 컨트롤러
* 요청 들어오는거 분개하는 컨트롤러
* 컨트롤러는 3개로 나누고 어차피 서버는 한대니까
* 큼직한 컨트롤러에서 WHEN으로 분개하기
* 작성인 : 박재형
* 기능 하나에 하나만 구현되도록 수정한다.
* */
@RestController
class UserController {

    //사용자 정보 요청 시 그리고 로그인관련
    @PostMapping("/API/user")
    fun user () : ResponseEntity<Any>{
        //구분코드
        var downChannel : String? = null;

        when(downChannel){
            "login" -> ""
        }
        var userResponse : UserResponse? = null
        userResponse?.ResponseData = "hello"
        return ResponseEntity.ok("{ data : hello }")
    }

    //사용자 정보 요청 시 그리고 로그인관련
    @GetMapping("/API/getuser")
    fun getuser () : String {
        //구분코드
        var downChannel : String? = null;

        when(downChannel){
            "login" -> ""
        }

        return "hellotest"
    }

}