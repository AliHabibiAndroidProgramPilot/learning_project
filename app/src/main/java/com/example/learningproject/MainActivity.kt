package com.example.learningproject

import android.app.Application
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items: Array<String> = arrayOf("Apple" , "Iphone", "Google", "Pixel", "Samsung", "S24", "Microsoft", "Windows", "Linux", "Debian")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        binding.ListView.adapter = adapter
        binding.ListView.setOnItemClickListener { _, _, index, _ ->
            Toast.makeText(this, items[index], Toast.LENGTH_SHORT).show()
        }
    }
}