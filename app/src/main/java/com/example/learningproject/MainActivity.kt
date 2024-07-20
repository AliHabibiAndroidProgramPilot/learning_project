package com.example.learningproject

import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var isChecked = false
        binding.extendFloatingButton.setOnClickListener {
            isChecked = if (isChecked) {
                binding.extendFloatingButton.extend()
                false
            } else {
                binding.extendFloatingButton.shrink()
                true
            }
        }
    }
}