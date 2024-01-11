package com.jay.backend.order.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder

@Builder
data class ProdcutMenuResponse (

    @JsonProperty("menu_id")
    var menuId : String,

    @JsonProperty("menu_name")
    var menuName : String,

    @JsonProperty("menu_name_en")
    var menuNameEn : String,

    @JsonProperty("menu_filter")
    var menuFilter : String,

    @JsonProperty("menu_filter_en")
    var menuFilterEn : String,

    @JsonProperty("coffee_brand_div_cd")
    var coffeeBrandDivCd : String,

    @JsonProperty("ice_hot_div_cd")
    var iceHotDivCd : String,

    @JsonProperty("enable_size")
    var enableSize : String,

    @JsonProperty("price")
    var price : Int
)