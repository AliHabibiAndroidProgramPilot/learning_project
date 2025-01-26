package com.example.learningproject

import android.util.Log
import com.example.learningproject.model.MainModel
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

    fun sendText(to: String, text: String) {
        RetrofitService.apiService.sendText(to = to, text = text).enqueue(
            object : Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    if (response.isSuccessful) {
                        val result = response.body() as MainModel
                        Log.i("TEST", result.message)
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {

                }

            }
        )
    }

}