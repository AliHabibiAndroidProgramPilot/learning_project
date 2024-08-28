package com.example.learningproject

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.example.learningproject.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val content: Array<String> = arrayOf("apple", "samsung", "Google Pixel", "Nothing", "Honor", "Nokia")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            content
        )
        binding.autoComplete.setAdapter(adapter)
        binding.autoComplete.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        binding.autoComplete.setOnFocusChangeListener { _, focused ->
            if (focused) binding.autoComplete.showDropDown()
        }
    }
}