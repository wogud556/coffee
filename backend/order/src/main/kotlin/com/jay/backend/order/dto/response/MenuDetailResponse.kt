package com.jay.backend.order.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder

@Builder
data class MenuDetailResponse(

    @JsonProperty("menu_id")
    var menuId: String,

    @JsonProperty("menu_name")
    var menuName: String,

    @JsonProperty("menu_name_en")
    var menuNameEn: String,

    @JsonProperty("ice_hot_div_cd")
    var iceHotDivCd: ArrayList<String>,

    @JsonProperty("enable_size")
    var enableSize : ArrayList<String>,

    @JsonProperty("price")
    var price: Int,

    @JsonProperty("image")
    var image: ArrayList<String>
)