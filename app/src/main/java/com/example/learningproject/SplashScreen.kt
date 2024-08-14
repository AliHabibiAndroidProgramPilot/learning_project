package com.example.learningproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.SplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var splashBinding: SplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        anim.duration = 450
        anim.fillAfter = true
        splashBinding.logo.startAnimation(anim)
        Handler(mainLooper).postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
       , 3200)
    }
}