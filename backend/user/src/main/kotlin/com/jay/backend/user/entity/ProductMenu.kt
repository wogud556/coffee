package com.jay.backend.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.NoArgsConstructor

@Entity
@Table(name = "PRODUCT_MENU")
@NoArgsConstructor
//@IdClass -> PK가 여러개가 될 수 있을 때 변경
data class ProductMenu (
    @Id
    @Column(name = "MENU_ID")
    var menuId : String,

    @Column(name = "MENU_NAME")
    var menuName : String,

    @Column(name = "MENU_NAME_EN")
    var menuNameEn : String,

    @Column(name = "MENU_FILTER")
    var menuFilter : String,

    @Column(name = "MENU_FILTER_EN")
    var menuFilterEn : String,

    @Column(name = "COFFEE_BRAND_DIV_CD")
    var coffeeBrandDivCd : String,

    @Column(name = "ICE_HOT_DIV_CD")
    var iceHotDivCd : String,

    @Column(name = "ENABLE_SIZE")
    var enableSize : String,

    @Column(name = "PRICE")
    var price : Int
)
