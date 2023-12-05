package com.jay.front.coffee.dto


data class PostModel(
    var id : String?=null,
    var pwd: String?=null,
    var nick: String?=null
)

data class PostResult(
    var result:String? = null
)