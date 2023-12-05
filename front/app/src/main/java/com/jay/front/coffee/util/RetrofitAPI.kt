package com.jay.front.coffee.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jay.front.coffee.dto.PostModel
import com.jay.front.coffee.dto.PostResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitAPI {

        @POST("user")
        @Headers("accept: application/json",
                "content-type: application/json")
        fun post_user(

        ): Call<PostResult>

        companion object {
                private const val BASE_URL = "http://10.0.2.2:8080/API/"

                fun create(): RetrofitAPI{
                        val gson : Gson = GsonBuilder().setLenient().create()

                        return Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .build()
                                .create(RetrofitAPI::class.java)
                }
        }
}