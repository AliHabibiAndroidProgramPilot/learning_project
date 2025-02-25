package com.example.learningproject.presenter

import com.example.learningproject.ext.ActivityLifecycle
import com.example.learningproject.model.ModelMainActivity
import com.example.learningproject.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : ActivityLifecycle {

    override fun onCreate() {
        initializeData()
    }

    private fun initializeData() {
        val text = model.setMainText()
        view.setMainText(text)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}