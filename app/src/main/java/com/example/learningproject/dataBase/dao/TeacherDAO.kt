package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteException
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
    fun deleteById(teacherId: String): Boolean {
        val writeDataBase = accessDataBase.writableDatabase
        val deleteResult = writeDataBase.delete(
            DataBaseHelper.TEACHER_TABLE,
            "${DataBaseHelper.TEACHER_ID} = ?",
            arrayOf(teacherId)
        )
        writeDataBase.close()
        return deleteResult > 0
    }
    fun deleteAll() {
        try {
            val writeDataBase = accessDataBase.writableDatabase
            writeDataBase.execSQL("DELETE FROM ${DataBaseHelper.TEACHER_TABLE}")
            writeDataBase.close()
        } catch (e: SQLiteException) {
            Log.i("SQLiteException", "Table Not Found")
        }
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