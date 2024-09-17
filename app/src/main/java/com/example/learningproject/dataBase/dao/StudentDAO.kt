package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.StudentDataModel

class StudentDAO(
    private val accessDataBase: DataBaseHelper
) {
    private val list = ArrayList<StudentDataModel>()
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
    fun selectAll(): ArrayList<StudentDataModel> {
        val readDataBase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.STUDENT_TABLE}"
        val cursor = readDataBase.rawQuery(sqlQuery, null)
        getData(cursor)
        readDataBase.close()
        return list
    }
    private fun getData(cursor: Cursor) {
        list.clear()
        if (cursor.moveToFirst()) {
            do {
                val studentId = cursor.getInt(0)
                val studentName = cursor.getString(1)
                val studentFamily = cursor.getString(2)
                val studentTeacherId = cursor.getInt(3)
                val studentAge = cursor.getInt(4)
                list.add(StudentDataModel(studentId, studentName, studentFamily, studentTeacherId, studentAge))
            } while (cursor.moveToNext())
        }
        cursor.close()
    }
}