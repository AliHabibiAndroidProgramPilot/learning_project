package com.example.learningproject

import android.graphics.drawable.Icon
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
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
        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
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
        initSeekBar()
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
    private fun initSeekBar() {
        binding.seekBar.max = mediaPlayer?.duration ?: 100
        val handler = Handler(mainLooper)
        handler.postDelayed(object: Runnable{
            override fun run() {
                try {
                    binding.seekBar.progress = mediaPlayer!!.currentPosition
                    handler.postDelayed(this, 20)
                } catch (e: Exception) {
                    binding.seekBar.progress = binding.seekBar.max
                }
            }

        }, 0)
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