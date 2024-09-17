package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.TeacherDataModel

class TeacherDAO(
    private val dbWritable: DataBaseHelper
) {
    fun insertTeacher(teacher: TeacherDataModel): Boolean{
        val dataBase = dbWritable.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.TEACHER_NAME, teacher.teacherName)
        contentValues.put(DataBaseHelper.TEACHER_FAMILY, teacher.teacherFamily)
        contentValues.put(DataBaseHelper.TEACHER_NATIONAL_CODE, teacher.teacherNationalCode)
        val insertDataResult =
            dataBase.insert(DataBaseHelper.TEACHER_TABLE, null, contentValues)
        dataBase.close()
        return insertDataResult > 0
    }
}