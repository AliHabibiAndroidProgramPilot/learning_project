package com.example.learningproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            /*
            binding.img.animate().alpha(1f).duration = 35000
            binding.img.animate().translationX(120f).duration = 15000
            binding.img.animate().translationY(120f).duration = 15000
            binding.img.animate().scaleY(2f).duration = 15000
            */
        }
    }
}