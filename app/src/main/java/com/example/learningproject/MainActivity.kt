package com.example.learningproject

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.example.learningproject.databinding.ActivityMainBinding
import com.example.learningproject.model.MainModel
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity(), ApiRespond {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            ApiRepository.instance.sendText(
                "bYc92CJsQu6utThQ1ZBwwqhTsXh6BTkkzmMn2APv",
                "This Time It's built by mySelf",
                this
            )
        }
    }

    override fun onRespond(respond: MainModel) {
        binding.txtApiRespond.text = respond.message
    }

    override fun onNotRespond(respond: String) {
        TODO("Not yet implemented")
    }

    override fun onRespondFailure(error: String) {
        TODO("Not yet implemented")
    }
}