package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import com.example.learningproject.dataBase.DataBaseHelper

class StudentDAO(
    private val dbWritable: DataBaseHelper
) {
    fun insertStudent(name: String, family: String, teacherCode: Int, age: Int) {
        val database = dbWritable.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.STUDENT_NAME, name)
        contentValues.put(DataBaseHelper.STUDENT_FAMILY, family)
        contentValues.put(DataBaseHelper.STUDENT_TEACHER_ID, teacherCode)
        contentValues.put(DataBaseHelper.STUDENT_AGE, age)
        database.insert(DataBaseHelper.STUDENT_TABLE, null, contentValues)
        database.close()
    }
}