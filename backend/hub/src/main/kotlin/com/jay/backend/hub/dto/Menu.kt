package com.jay.backend.hub.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
@JsonIgnoreProperties
data class Menu (
    private var coffeeDivCd : String?,
)