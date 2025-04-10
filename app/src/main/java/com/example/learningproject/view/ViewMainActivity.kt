package com.example.learningproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.example.learningproject.databinding.ActivityMainBinding
import com.example.learningproject.ext.ActivityUtils

class ViewMainActivity : FrameLayout {

    private lateinit var utility: ActivityUtils

    constructor(contextInstance: Context) : super(contextInstance)
    constructor(contextInstance: Context, utils: ActivityUtils) : super(contextInstance) {
        utility = utils
    }

    // Initialize View Binding
    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun viewDragAndDrop() {
        binding.mainView.setOnTouchListener(object : OnTouchListener {
            // Record Last Touch Position
            private var dx: Float = 0f
            private var dy: Float = 0f

            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                when (event?.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        dx = view?.x!! - event.rawX
                        dy = view.y - event.rawY
                        return true
                    }

                    MotionEvent.ACTION_MOVE -> {
                        view!!.animate()
                            .x(event.rawX + dx)
                            .y(event.rawY + dy)
                            .setDuration(0)
                            .start()
                        return true
                    }

                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        binding.mainView.performClick()
                        return true
                    }
                }
                return false
            }
        })
    }

    fun onFinishButton() {
        binding.btnFinish.setOnClickListener { utility.finished() }
    }

    fun showToast(toastText: CharSequence) {
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
    }

}