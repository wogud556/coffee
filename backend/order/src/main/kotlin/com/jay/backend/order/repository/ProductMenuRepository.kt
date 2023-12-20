package com.jay.backend.order.repository

import com.jay.backend.order.entity.ProductMenu
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductMenuRepository : JpaRepository<ProductMenu, Long> {
    @Transactional
    fun findByCoffeeBrandDivCd(COFFEE_BRAND_DIV_CD : String) : List<ProductMenu>
    //fun findByMenuFilterEn(MENU_FILTER_EN : String, COFFEE_BRAND_DIV_CD : String) : List<ProductMenu>


}