package com.example.learningproject

import android.graphics.drawable.Icon
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var fabIconState = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabPlay.setOnClickListener {
           setFabImage()
            playPauseMusic()
        }
        binding.fabStop.setOnClickListener {
            stopMusic()
            fabIconState = false
            setFabImage()
        }
    }

    private fun playPauseMusic() {
        if(mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.test_sound)
        mediaPlayer?.start()
        if (fabIconState)
            mediaPlayer?.pause()
        mediaPlayer?.setOnCompletionListener {
            stopMusic()
            setFabImage()
        }
    }
    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
    private fun setFabImage() {
        fabIconState = if (!fabIconState) {
            binding.fabPlay.setImageIcon(Icon.createWithResource(this, R.drawable.ic_play))
            true
        } else {
            binding.fabPlay.setImageIcon(Icon.createWithResource(this, R.drawable.ic_pause))
            false
        }
    }
}