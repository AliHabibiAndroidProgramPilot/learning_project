package com.example.learningproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.example.learningproject.databinding.ActivityMainBinding
import com.example.learningproject.ext.ActivityUtils

class ViewMainActivity : FrameLayout {

    private lateinit var utility: ActivityUtils

    constructor(contextInstance: Context) : super(contextInstance)
    constructor(contextInstance: Context, utils: ActivityUtils) : super(contextInstance) {
        utility = utils
    }

    // Initialize View Binding
    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setMainText(name: String) {
        binding.txtMain.textAlignment = View.TEXT_ALIGNMENT_CENTER
        binding.txtMain.text = name
    }

    fun onFinishButton() {
        binding.btnFinish.setOnClickListener { utility.finished() }
    }

    fun showToast(toastText: CharSequence) {
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
    }

}