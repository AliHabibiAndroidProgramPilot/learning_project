package com.example.learningproject

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val todayDate = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(
                this,
                { _, hour, minute ->
                    binding.textView.text = "$hour : $minute"
                },
                todayDate.get(Calendar.HOUR_OF_DAY),
                todayDate.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        }
}
}