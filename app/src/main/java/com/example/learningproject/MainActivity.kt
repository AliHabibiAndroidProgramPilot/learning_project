package com.example.learningproject

import android.os.Bundle
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
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FirstFragment())
            .commit()
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
        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item_1 -> {
                   supportFragmentManager.beginTransaction()
                       .replace(R.id.fragmentContainer, FirstFragment())
                       .commit()
                    binding.drawableLayoutParent.closeDrawers()
                    true
                }
                R.id.item_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, SecondFragment())
                        .commit()
                    binding.drawableLayoutParent.closeDrawers()
                    true
                }
                R.id.item_3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ThirdFragment())
                        .commit()
                    binding.drawableLayoutParent.closeDrawers()
                    true
                }
                R.id.item_4 -> {
                    Toast.makeText(this, "item 4", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_5 -> {
                    Toast.makeText(this, "item 5", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}