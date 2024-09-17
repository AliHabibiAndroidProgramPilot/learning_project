package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.StudentDataModel

class StudentDAO(
    private val accessDataBase: DataBaseHelper
) {
    fun insertStudent(student: StudentDataModel): Boolean {
        val writeDataBase = accessDataBase.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.STUDENT_NAME, student.studentName)
        contentValues.put(DataBaseHelper.STUDENT_FAMILY, student.studentFamily)
        contentValues.put(DataBaseHelper.STUDENT_TEACHER_ID, student.studentTeacherId)
        contentValues.put(DataBaseHelper.STUDENT_AGE, student.studentAge)
        val insertDataResult =
            writeDataBase.insert(DataBaseHelper.STUDENT_TABLE, null, contentValues)
        writeDataBase.close()
        return insertDataResult > 0
    }
}