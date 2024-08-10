package com.example.learningproject

import android.content.Intent
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
        binding.btnTest.setOnClickListener { startActivity(Intent(this, TestActivity::class.java)) }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.delete_item -> {
                Toast.makeText(this, "delete", Toast.LENGTH_LONG).show()
                true
            }
            R.id.Exit_item -> {
                Toast.makeText(this, "Exit", Toast.LENGTH_LONG).show()
                true
            }
            R.id.share_item -> {
                Toast.makeText(this, "share", Toast.LENGTH_LONG).show()
                true
            }
            R.id.rename_item -> {
                Toast.makeText(this, "rename", Toast.LENGTH_LONG).show()
                true
            }
            R.id.report_item -> {
                Toast.makeText(this, "report", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }
    }
}