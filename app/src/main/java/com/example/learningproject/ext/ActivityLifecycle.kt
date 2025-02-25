package com.example.learningproject.ext

interface ActivityLifecycle {
    fun onCreate()

    fun onStart() {}

    fun onResume() {}

    fun onPause() {}

    fun onStop() {}

    fun onRestart() {}

    fun onDestroy() {}
}