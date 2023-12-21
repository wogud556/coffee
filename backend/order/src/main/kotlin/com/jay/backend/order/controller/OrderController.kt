package com.jay.backend.order.controller

import com.jay.backend.order.dto.response.ProdcutMenuResponse
import com.jay.backend.order.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/*
* order controller
* 우선 컨트롤러단에 소스 때려박고서 서비스로 이관하는 작업 진행
* : ResponseEntity<ProdcutMenuResponse>
* @RequestParam(required = false) coffeeDivCd : String
* */
@RestController
class OrderController(
        private val orderService: OrderService
)
{

        @PostMapping("/menu")
        fun order () : List<ProdcutMenuResponse> {
            return orderService.getMenuByCoffeeDivCd("STBS")

        }
}