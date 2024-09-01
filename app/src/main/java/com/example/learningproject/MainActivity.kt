package com.example.learningproject

import android.app.Application
import android.os.Bundle
import android.provider.ContactsContract.Data
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
        val items = arrayOf(
            DataProduct(1, "shoes", "45$", R.drawable.gray),
            DataProduct(2, "blanket", "12$", R.drawable.gray),
            DataProduct(3, "jacket", "360$", R.drawable.gray)
        )
        val adapter = ListViewAdapter(this, items)
        binding.ListView.adapter = adapter
        /*binding.ListView.setOnItemClickListener { _, _, index, _ ->
            Toast.makeText(this, items[index], Toast.LENGTH_SHORT).show()
        }*/
    }
}