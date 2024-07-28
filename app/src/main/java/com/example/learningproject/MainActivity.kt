package com.example.learningproject

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabPlay.setOnClickListener { playMusic() }
        binding.fabPause.setOnClickListener { pauseMusic() }
        binding.fabStop.setOnClickListener { stopMusic() }
    }

    private fun playMusic() {
        if(mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.test_sound)
        mediaPlayer?.setOnCompletionListener { stopMusic() }
        mediaPlayer?.start()
    }

    private fun pauseMusic() { mediaPlayer?.pause() }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}