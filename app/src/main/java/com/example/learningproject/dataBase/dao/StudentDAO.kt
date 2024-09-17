package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.StudentDataModel

class StudentDAO(
    private val dataBaseWritable: DataBaseHelper
) {
    fun insertStudent(student: StudentDataModel): Boolean {
        val database = dataBaseWritable.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.STUDENT_NAME, student.studentName)
        contentValues.put(DataBaseHelper.STUDENT_FAMILY, student.studentFamily)
        contentValues.put(DataBaseHelper.STUDENT_TEACHER_ID, student.studentTeacherId)
        contentValues.put(DataBaseHelper.STUDENT_AGE, student.studentAge)
        val insertDataResult =
            database.insert(DataBaseHelper.STUDENT_TABLE, null, contentValues)
        database.close()
        return insertDataResult > 0
    }
}