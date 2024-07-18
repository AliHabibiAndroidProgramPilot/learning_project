package com.example.learningproject

import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences = getSharedPreferences("userRating", MODE_PRIVATE)
        binding.rbStarts.rating = sharedPreferences.getFloat("rate", 0.0f)
        binding.rbStarts.setOnRatingBarChangeListener { _, rating, _ ->
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putFloat("rate", rating)
            editor.apply()
            Toast.makeText(this, rating.toString(), Toast.LENGTH_LONG).show()
        }
    }
}