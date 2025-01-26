package com.example.learningproject

import com.example.learningproject.model.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("send")
    fun sendText(@Query("to") to: String, @Query("text") text: String): Call<MainModel>

}