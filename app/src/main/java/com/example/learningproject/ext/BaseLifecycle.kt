package com.example.learningproject.ext

interface BaseLifecycle {

    fun onCreate()

    fun onStart() {}

    fun onResume() {}

    fun onPause() {}

    fun onStop() {}

    fun onRestart() {}

    fun onDestroy() {}

}