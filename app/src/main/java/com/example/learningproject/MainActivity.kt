package com.example.learningproject

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.show.setOnClickListener {
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            dialog.setTitle("Error Found")
            dialog.setMessage("User within the local database not found")
            dialog.setNeutralButton("Retry") { _, _ ->  }
            dialog.setPositiveButton("Report") { _, _ ->  }
            dialog.setNegativeButton("Ignore") { _, _ ->  }
            dialog.setIcon(R.drawable.ic_add)
            dialog.create().show()
        }
    }
}