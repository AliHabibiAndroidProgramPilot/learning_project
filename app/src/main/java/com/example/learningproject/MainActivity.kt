package com.example.learningproject

import android.os.Bundle
import android.util.Log
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
        /*val teachersList = arrayOf(
            TeacherDataModel(1, "Ali", "Nori", "0123456789"),
            TeacherDataModel(2, "Ali", "Nori", "0123456789"),
            TeacherDataModel(3, "Ali", "Nori", "0123456789"),
            TeacherDataModel(4, "Ali", "Nori", "0123456789"),
            TeacherDataModel(5, "Ali", "Nori", "test"),
            TeacherDataModel(5, "Ali", "Nori", "888")
        )
        val studentsList = arrayOf(
            StudentDataModel(1, "Ali", "Habibi", 1, 18),
            StudentDataModel(1, "Ali", "Habibi", 2, 19),
            StudentDataModel(1, "Ali", "Habibi", 3, 22),
            StudentDataModel(1, "Ali", "Habibi", 4, 20),
            StudentDataModel(1, "Ali", "Habibi", 5, 19),
            StudentDataModel(1, "Ali", "Habibi", 5, 80)
        )
        //Matters That Which Table Initialized First
          for (item in teachersList)
              TeacherDAO(dataBase).insertTeacher(item)
          for (item in studentsList)
              StudentDAO(dataBase).insertStudent(item)*/
    }
}