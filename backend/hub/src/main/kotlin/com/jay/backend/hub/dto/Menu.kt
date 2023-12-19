package com.jay.backend.hub.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data

@Data
data class Menu (
    @JsonProperty("id") private var postId : Long,
)