package com.example.learningproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClike.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("phoneNumber", "09924025474")
            intent.putExtra("id", 1822)
            startActivity(intent)
        }
    }
}