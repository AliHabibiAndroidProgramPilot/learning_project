package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabItem = arrayOf("Click", "Learning Project", "TODO")
        binding.viewPager.adapter = CustomAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabItem[position]
        } .attach()
    }
}