package com.example.learningproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("send")
    fun sendText(@Query("to") token: String, @Query("text") text: String): Call<String>

}