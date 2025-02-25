package com.example.learningproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.learningproject.databinding.ActivityMainBinding

class ViewMainActivity(contextInstance: Context) : FrameLayout(contextInstance) {
    // Initialize View Binding
    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setMainText(name: String) {
        binding.txtMain.textAlignment = View.TEXT_ALIGNMENT_CENTER
        binding.txtMain.text = name
    }
}