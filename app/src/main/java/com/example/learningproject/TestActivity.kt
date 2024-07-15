package com.example.learningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learningproject.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrevious.setOnClickListener {
            val phoneNumber: String? = intent.getStringExtra("phoneNumber")
            val id: Int = intent.getIntExtra("id", 0)
            Toast.makeText(this,"phone: $phoneNumber id: $id", Toast.LENGTH_SHORT).show()

        }
    }
}