package com.example.learningproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.example.learningproject.model.MainModel

class MainActivity : AppCompatActivity(), ApiRespond {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            it.isEnabled = false
            binding.progressBar.visibility = View.VISIBLE
            ApiRepository.instance.sendText(
                "bYc92CJsQu6utThQ1ZBwwqhTsXh6BTkkzmMn2APv",
                "No Limit I'm Fucking Solider",
                this
            )
        }
    }

    override fun onRespond(respond: MainModel) {
        binding.txtApiRespond.text = respond.message
        binding.progressBar.visibility = View.INVISIBLE
        binding.btn.isEnabled = true
    }

    override fun onNotRespond(respond: String) {

    }

    override fun onRespondFailure(error: String?) {
        if (error != null) {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.INVISIBLE
            binding.btn.isEnabled = true
        }
    }
}