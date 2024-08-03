package com.example.learningproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import java.lang.reflect.Array.set
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calendarView.setOnDateChangeListener { _, year, month, day ->
            binding.textView.text = "$year/$day/${month + 1}"
        }
    }
}