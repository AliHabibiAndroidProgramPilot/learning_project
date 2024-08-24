package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /*private val drawerLayout: DrawerLayout
        get() = binding.drawableLayoutParent
    private val actionBarDrawerToggle: ActionBarDrawerToggle
        get() = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawableLayoutParent,
            binding.toolBar,
            R.string.nav_open,
            R.string.nav_close
        )
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        binding.drawableLayoutParent.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
}