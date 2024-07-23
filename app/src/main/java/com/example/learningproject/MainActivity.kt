package com.example.learningproject

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.learningproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.show.setOnClickListener {
            val snackBar = Snackbar.make(binding.root, "No Connection", Snackbar.LENGTH_LONG)
            snackBar.setAction("Ok") {
                snackBar.dismiss()
            }
            snackBar.setTextColor(Color.WHITE)
            snackBar.setActionTextColor(Color.MAGENTA)
            snackBar.setBackgroundTint(Color.RED)
            snackBar.setActionTextColor(Color.YELLOW)
            snackBar.show()
        }
    }
}