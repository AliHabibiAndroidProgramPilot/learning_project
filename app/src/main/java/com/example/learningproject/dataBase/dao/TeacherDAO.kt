package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.TeacherDataModel

class TeacherDAO(
    private val accessDataBase: DataBaseHelper
) {
    private val data = ArrayList<TeacherDataModel>()
    private lateinit var cursor: Cursor
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
        cursor =
            readDataBase.rawQuery("SELECT * FROM ${DataBaseHelper.TEACHER_TABLE}", null)
        getData()
        cursor.close()
        readDataBase.close()
        return data
    }

    fun selectByColumn(columnName: String, columnValue: String): ArrayList<TeacherDataModel> {
        val readDatabase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.TEACHER_TABLE} WHERE $columnName = ?"
        cursor =
            readDatabase.rawQuery(sqlQuery, arrayOf(columnValue))
        getData()
        cursor.close()
        readDatabase.close()
        return data
    }

    private fun getData() {
        data.clear()
        try {
            if (cursor.moveToFirst()) {
                do {
                    val id: Int =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.TEACHER_ID))
                    val teacherName: String =
                        cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.TEACHER_NAME))
                    val teacherFamily: String =
                        cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.TEACHER_FAMILY))
                    val teacherNationalCode: String =
                        cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.TEACHER_NATIONAL_CODE))
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
        } catch (e: IllegalArgumentException) {
            Log.e("ILLEGAL_ARGUMENT_EXCEPTION", e.message.toString())
        }
    }
}