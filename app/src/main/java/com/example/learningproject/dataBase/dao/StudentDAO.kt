package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.StudentDataModel
import com.example.learningproject.dataBase.dataModel.TeacherDataModel

class StudentDAO(
    private val accessDataBase: DataBaseHelper
) {
    private val list = ArrayList<StudentDataModel>()
    private lateinit var cursor: Cursor
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
        cursor = readDataBase.rawQuery(sqlQuery, null)
        getData()
        readDataBase.close()
        return list
    }
    fun selectByColumn(columnName: String, columnValue: String): ArrayList<StudentDataModel> {
        val readDatabase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.STUDENT_TABLE} WHERE $columnName = ?"
        cursor =
            readDatabase.rawQuery(sqlQuery, arrayOf(columnValue))
        getData()
        readDatabase.close()
        cursor.close()
        return list
    }
    private fun getData() {
        list.clear()
        if (cursor.moveToFirst()) {
            do {
                val id: Int = cursor.getInt(0)
                val studentName: String = cursor.getString(1)
                val studentFamily: String = cursor.getString(2)
                val studentTeacherId: Int = cursor.getInt(3)
                val studentAge: Int = cursor.getInt(4)
                list.add(
                    StudentDataModel(
                        id,
                        studentName,
                        studentFamily,
                        studentTeacherId,
                        studentAge
                    )
                )
            } while (cursor.moveToNext())
        }
    }
}