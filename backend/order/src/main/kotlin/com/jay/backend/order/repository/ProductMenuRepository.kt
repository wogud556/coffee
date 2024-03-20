package com.jay.backend.order.repository

import com.jay.backend.order.entity.ProductMenu
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface ProductMenuRepository : JpaRepository<ProductMenu, Long> {
    @Transactional
    fun findByCoffeeBrandDivCd(COFFEE_BRAND_DIV_CD : String?) : List<ProductMenu>
    fun findByCoffeeBrandDivCdAndMenuFilterEn(COFFEE_BRAND_DIV_CD : String?, MENU_FILTER_EN : String?) : List<ProductMenu>

    @Query(
        value = "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBFIZ0001' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBESP0004' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBTEA0003' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBCLD0005' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBRFE0001' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBFRA0001' UNION " +
                "SELECT a.* FROM PRODUCT_MENU a WHERE a.MENU_ID = 'SBBLE0001'"
        , nativeQuery = true
    )
    @Transactional
    fun findByRole() : List<ProductMenu>

    fun findByCoffeeBrandDivCdAndMenuId(COFFEE_BRAND_DIV_CD : String?, MENU_ID : String?) : ProductMenu

}