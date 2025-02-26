package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.ext.ActivityUtils
import com.example.learningproject.model.ModelMainActivity
import com.example.learningproject.presenter.PresenterMainActivity
import com.example.learningproject.view.ViewMainActivity

class MainActivity : AppCompatActivity(), ActivityUtils {
    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ModelMainActivity()
        val view = ViewMainActivity(this, this)
        setContentView(view.binding.root)
        presenter = PresenterMainActivity(view, model)
        presenter.onCreate()
    }

    override fun onResume() {
        presenter.onResume()
        super.onResume()
    }

    override fun finished() {
        finish()
    }

}