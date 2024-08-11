package com.example.learningproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun onClick(view: View) {
        when(view.id) {
            R.id.btn_scale -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.scale)
                anim.fillAfter = true
                anim.duration = 1500
                binding.img.startAnimation(anim)

            }
            R.id.btn_rotate -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.rotate)
                anim.fillAfter = true
                anim.duration = 1500
                binding.img.startAnimation(anim)
            }
            R.id.btn_scaleRotate -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.scale_rotate)
                anim.fillAfter = true
                anim.duration = 2000
                binding.img.startAnimation(anim)
            }
            R.id.btn_Fadein -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
                anim.fillAfter = true
                anim.duration = 1500
                binding.img.startAnimation(anim)
            }
            R.id.btn_fadeout -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.fade_out)
                anim.fillAfter = true
                anim.duration = 1500
                binding.img.startAnimation(anim)
            }
            R.id.btn_translate -> {
                val anim = AnimationUtils.loadAnimation(this, R.anim.translate)
                anim.fillAfter = true
                anim.duration = 1500
                binding.img.startAnimation(anim)
            }
        }
    }
}