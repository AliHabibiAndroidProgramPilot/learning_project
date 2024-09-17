package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import com.example.learningproject.dataBase.DataBaseHelper

class TeacherDAO(
    private val dbWritable: DataBaseHelper
) {
    fun insertTeacher(name: String, family:String, nationalCode: String) {
        val dataBase = dbWritable.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.TEACHER_NAME, name)
        contentValues.put(DataBaseHelper.TEACHER_FAMILY, family)
        contentValues.put(DataBaseHelper.TEACHER_NATIONAL_CODE, nationalCode)
        dataBase.insert(DataBaseHelper.TEACHER_TABLE, null, contentValues)
        dataBase.close()
    }
}