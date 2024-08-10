package com.example.learningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Makes the back icon appear in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    // Called when back icon in action bar is Clicked
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}