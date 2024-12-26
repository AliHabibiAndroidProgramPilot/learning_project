package com.example.learningproject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository private constructor() {

    companion object {
        // Singleton Pattern
        private var apiRepository: ApiRepository? = null
        val instance: ApiRepository
            get() {
                if (apiRepository == null)
                    apiRepository = ApiRepository()
                return apiRepository!!
            }
    }

    fun sendText(token: String, text: String) {
        RetrofitService.apiService.sendText(token = token, text = text).enqueue(
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

}