package com.jay.backend.order.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder

@Builder
data class FilterNmResponse (

    @JsonProperty("menu_filter")
    var menuFilter : String,

    @JsonProperty("menu_filter_en")
    var menuFilterEn : String,

    @JsonProperty("image")
    var image : String
)