package com.example.learningproject

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.CustomRecyclerViewBinding

class CustomRecycler(context: Context, attributes: AttributeSet) :
    FrameLayout(context, attributes) {

    private val binding = CustomRecyclerViewBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
        initializeAttributes(attributes)
    }

    private fun initializeAttributes(attributes: AttributeSet) {
        context.obtainStyledAttributes(attributes, R.styleable.CustomRecycler)
            .apply {
                val title = getString(R.styleable.CustomRecycler_title)
                binding.txtTitle.text = title
                recycle()
            }
    }

    fun recycler(): RecyclerView = binding.recycler

}