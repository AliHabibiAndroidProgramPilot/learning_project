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
    private val contentValues = ContentValues()
    fun insert(teacher: TeacherDataModel): Boolean {
        val writeDatabase = accessDataBase.writableDatabase
        setContentValues(teacher)
        val insertResult =
            writeDatabase.insert(DataBaseHelper.TEACHER_TABLE, null, contentValues)
        writeDatabase.close()
        return insertResult > 0
    }
    fun update(teacherId: String, teacher: TeacherDataModel): Boolean {
        val writeDataBase = accessDataBase.writableDatabase
        setContentValues(teacher)
        val updateResult =
            writeDataBase.update(
                DataBaseHelper.TEACHER_TABLE,
                contentValues,
                "${DataBaseHelper.TEACHER_ID} = ?",
                arrayOf(teacherId)
            )
        writeDataBase.close()
        return updateResult > 0
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
    fun deleteAll(): Boolean {
        return try {
            val writeDataBase = accessDataBase.writableDatabase
            writeDataBase.execSQL("DELETE FROM ${DataBaseHelper.TEACHER_TABLE}")
            writeDataBase.close()
            true
        } catch (e: SQLiteException) {
            Log.i("SQLiteException", "Table Not Found")
            false
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
                    val teacherAge =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.TEACHER_AGE))
                    data.add(
                        TeacherDataModel(
                            id,
                            teacherName,
                            teacherFamily,
                            teacherNationalCode,
                            teacherAge
                        )
                    )
                } while (cursor.moveToNext())
            }
        } catch (e: IllegalArgumentException) {
            Log.e("ILLEGAL_ARGUMENT_EXCEPTION", e.message.toString())
        }
    }
    private fun setContentValues(teacher: TeacherDataModel) {
        contentValues.clear()
        contentValues.put(DataBaseHelper.TEACHER_NAME, teacher.teacherName)
        contentValues.put(DataBaseHelper.TEACHER_FAMILY, teacher.teacherFamily)
        contentValues.put(DataBaseHelper.TEACHER_NATIONAL_CODE, teacher.teacherNationalCode)
        contentValues.put(DataBaseHelper.TEACHER_AGE, teacher.teacherAge)
    }
}