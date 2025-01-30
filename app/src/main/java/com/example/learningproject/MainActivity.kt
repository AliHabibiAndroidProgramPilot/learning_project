package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUrl = "https://m.media-amazon.com/images/M/MV5BNzIzMjBiNDUtOWQ1ZC00ZDY1LWJkZmQtN2E3ZTRiMWQzZDU1XkEyXkFqcGc@._V1_.jpg"
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.gray)
            .error(R.drawable.ic_launcher_background)
            .into(binding.imageView)
    }
}