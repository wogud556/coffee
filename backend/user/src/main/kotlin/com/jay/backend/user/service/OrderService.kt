package com.jay.backend.order.service

import com.jay.backend.order.dto.response.ProdcutMenuResponse
import com.jay.backend.order.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class OrderService (
    private val productMenuRepository : UserRepository
) {
    companion object {

    }
    fun getMenuByCoffeeDivCd (body : HashMap<String, String>) : List<ProdcutMenuResponse> {

        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCd(body.get("coffeeDivCd"))

        return coffeeMenuAll.map {
            ProdcutMenuResponse(
                menuId = it.menuId,
                menuName = it.menuName,
                menuNameEn = it.menuNameEn,
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                coffeeBrandDivCd = it.coffeeBrandDivCd,
                iceHotDivCd = it.iceHotDivCd,
                enableSize = it.enableSize,
                price = it.price
            )
        }
    }

    fun getMenuByCoffeeDivCdFilterEn (body : HashMap<String, String>) : List<ProdcutMenuResponse> {
        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCdAndMenuFilterEn(body.get("coffeeDivCd"), body.get("filter"))

        return coffeeMenuAll.map {
            ProdcutMenuResponse(
                menuId = it.menuId,
                menuName = it.menuName,
                menuNameEn = it.menuNameEn,
                menuFilter = it.menuFilter,
                menuFilterEn = it.menuFilterEn,
                coffeeBrandDivCd = it.coffeeBrandDivCd,
                iceHotDivCd = it.iceHotDivCd,
                enableSize = it.enableSize,
                price = it.price
            )
        }
    }
}