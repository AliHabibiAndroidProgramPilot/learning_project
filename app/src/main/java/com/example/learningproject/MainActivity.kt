package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMainLogin.setOnClickListener { replace(R.id.fragmentContainer, LoginFragment()) }
        binding.btnImage.setOnClickListener { replace(R.id.fragmentContainer, ImageFragment()) }
    }
    private fun replace(viewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(viewId, fragment)
            .commit()
    }
}