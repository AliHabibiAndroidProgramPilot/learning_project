package com.example.learningproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learningproject.databinding.ImageFragmentBinding

class ImageFragment : Fragment(R.layout.image_fragment) {
    private lateinit var binding: ImageFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ImageFragmentBinding.inflate(inflater)

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {}
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(context, "test", Toast.LENGTH_LONG).show()
            }
        })
        return binding.root
    }
}