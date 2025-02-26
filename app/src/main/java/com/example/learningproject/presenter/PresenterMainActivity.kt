package com.example.learningproject.presenter

import com.example.learningproject.ext.BaseLifecycle
import com.example.learningproject.model.ModelMainActivity
import com.example.learningproject.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : BaseLifecycle {

    override fun onCreate() {
        initializeData()
        btnFinished()
    }

    override fun onResume() {
        showToast()
        super.onResume()
    }

    private fun initializeData() {
        val text = model.setMainText()
        view.setMainText(text)
    }

    private fun showToast() {
        val toastText = model.getToastText()
        view.showToast(toastText)
    }

    private fun btnFinished() {
        view.onFinishButton()
    }

}