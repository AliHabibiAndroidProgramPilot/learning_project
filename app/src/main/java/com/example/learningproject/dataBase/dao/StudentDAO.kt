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
    fun findAll(): ArrayList<StudentDataModel> {
        val readDataBase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.STUDENT_TABLE}"
        val cursor = readDataBase.rawQuery(sqlQuery, null)
        val list = ArrayList<StudentDataModel>()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val studentName = cursor.getString(1)
                val studentFamily = cursor.getString(2)
                val studentTeacherId = cursor.getInt(3)
                val studentAge = cursor.getInt(4)
                list.add(StudentDataModel(id, studentName, studentFamily, studentTeacherId, studentAge))
            } while (cursor.moveToNext())
        }
        cursor.close()
        readDataBase.close()
        return list
    }
}