package com.example.learningproject

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

    fun sendText(to: String, text: String, apiRespond: ApiRespond) {
        RetrofitService.apiService.sendText(to = to, text = text).enqueue(
            object : Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    if (response.isSuccessful)
                        apiRespond.onRespond(response.body() as MainModel)
                    else if (!response.isSuccessful)
                        apiRespond.onNotRespond("Not Responding")
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    apiRespond.onRespondFailure(t.message)
                }

            }
        )
    }

}