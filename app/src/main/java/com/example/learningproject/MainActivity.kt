package com.example.learningproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dao.StudentDAO
import com.example.learningproject.dataBase.dao.TeacherDAO
import com.example.learningproject.dataBase.dataModel.StudentDataModel
import com.example.learningproject.dataBase.dataModel.TeacherDataModel
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataBase = DataBaseHelper(this)
        binding.btn.setOnClickListener {

        }
    }
}