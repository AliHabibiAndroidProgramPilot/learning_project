package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.TeacherDataModel

class TeacherDAO(
    private val accessDataBase: DataBaseHelper
) {
    private val data = ArrayList<TeacherDataModel>()

    fun insertTeacher(teacher: TeacherDataModel): Boolean {
        val writeDatabase = accessDataBase.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.TEACHER_NAME, teacher.teacherName)
        contentValues.put(DataBaseHelper.TEACHER_FAMILY, teacher.teacherFamily)
        contentValues.put(DataBaseHelper.TEACHER_NATIONAL_CODE, teacher.teacherNationalCode)
        val insertResult =
            writeDatabase.insert(DataBaseHelper.TEACHER_TABLE, null, contentValues)
        writeDatabase.close()
        return insertResult > 0
    }

    fun selectAll(): ArrayList<TeacherDataModel> {
        val readDataBase = accessDataBase.readableDatabase
        val cursor =
            readDataBase.rawQuery("SELECT * FROM ${DataBaseHelper.TEACHER_TABLE}", null)
        getData(cursor)
        cursor.close()
        readDataBase.close()
        return data
    }

    fun selectByColumn(columnName: String, columnValue: String): ArrayList<TeacherDataModel> {
        val readDatabase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.TEACHER_TABLE} WHERE $columnName = ?"
        val cursor =
            readDatabase.rawQuery(sqlQuery, arrayOf(columnValue))
        getData(cursor)
        cursor.close()
        readDatabase.close()
        return data
    }

    private fun getData(cursor: Cursor) {
        data.clear()
        if (cursor.moveToFirst()) {
            do {
                val id: Int = cursor.getInt(0)
                val teacherName: String = cursor.getString(1)
                val teacherFamily: String = cursor.getString(2)
                val teacherNationalCode: String = cursor.getString(3)
                data.add(
                    TeacherDataModel(
                        id,
                        teacherName,
                        teacherFamily,
                        teacherNationalCode
                    )
                )
            } while (cursor.moveToNext())
        }
    }
}