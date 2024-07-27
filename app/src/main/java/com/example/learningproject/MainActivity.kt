package com.example.learningproject

import android.os.Bundle
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.example.learningproject.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            val sheetDialog = BottomSheetDialog(this)
            val view = BottomSheetDialogBinding.inflate(layoutInflater)
            sheetDialog.setContentView(view.root)
            sheetDialog.setCancelable(false)
            sheetDialog.setTitle("test")
            view.btnDismiss.setOnClickListener {
                sheetDialog.dismiss()
            }
            sheetDialog.show()
        }
    }
}