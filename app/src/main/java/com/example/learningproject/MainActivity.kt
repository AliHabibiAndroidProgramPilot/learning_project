package com.example.learningproject

import android.graphics.drawable.Icon
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.widget.MediaController
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoView()
    }

    private fun initVideoView() {
        val uri = Uri.parse("android.resource://${packageName}/${R.raw.testvideo}")
        val controller = MediaController(this)
        try {
            binding.videoView.setVideoURI(uri)
            binding.videoView.setMediaController(MediaController(this))
            binding.videoView.start()
        } catch (e: Exception) {
            Toast.makeText(this, "${e.cause}", Toast.LENGTH_LONG).show()
        }
        binding.videoView.setOnPreparedListener{
            it.setOnVideoSizeChangedListener { _, _, _ ->
                controller.setAnchorView(binding.videoView)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}