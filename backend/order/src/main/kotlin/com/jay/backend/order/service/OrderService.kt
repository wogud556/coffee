package com.jay.backend.order.service

import com.jay.backend.order.dto.response.ProdcutMenuResponse
import com.jay.backend.order.repository.ProductMenuRepository
import org.springframework.stereotype.Service

@Service
class OrderService (
    private val productMenuRepository : ProductMenuRepository
) {
    companion object {

    }
    fun getMenuByCoffeeDivCd (coffeedivcd : String?) : List<ProdcutMenuResponse> {
        val coffeeMenuAll = productMenuRepository.findByCoffeeBrandDivCd(coffeedivcd)

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

    fun getMenuByCoffeeDivCdFilterEn (coffeedivcd : String?, menuFilterEn: String?) : List<ProdcutMenuResponse> {
        val coffeeMenuAll = productMenuRepository.findByMenuFilterEnAndCoffeeBrandDivCd(coffeedivcd, menuFilterEn)

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