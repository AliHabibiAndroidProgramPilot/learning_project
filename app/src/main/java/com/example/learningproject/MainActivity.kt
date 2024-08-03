package com.example.learningproject

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.widget.MediaController
import android.widget.VideoView
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
        binding.videoView.apply {
            val controller = MediaController(this@MainActivity)
            setVideoURI(Uri.parse("android.resource://${packageName}/${R.raw.testvideo}"))
            setMediaController(controller)
            start()
            setOnPreparedListener {
                it.setOnVideoSizeChangedListener { _, _, _ ->
                    controller.setAnchorView(binding.videoView)
                }
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("videoPosition", binding.videoView.currentPosition)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.videoView.seekTo(savedInstanceState.getInt("videoPosition"))
        super.onRestoreInstanceState(savedInstanceState)
    }
}