package com.example.learningproject

import com.example.learningproject.model.MainModel

interface ApiRespond {
    fun onRespond(respond: MainModel)
    fun onNotRespond(respond: String)
    fun onRespondFailure(error: String?)
}