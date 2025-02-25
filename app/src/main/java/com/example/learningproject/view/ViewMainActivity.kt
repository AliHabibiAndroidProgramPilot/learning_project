package com.example.learningproject.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.learningproject.databinding.ActivityMainBinding

class ViewMainActivity(contextInstance: Context) : FrameLayout(contextInstance) {
    // Initialize View Binding
    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))
}