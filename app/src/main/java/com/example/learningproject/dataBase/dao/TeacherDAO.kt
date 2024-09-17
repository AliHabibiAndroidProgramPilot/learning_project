package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import com.example.learningproject.dataBase.DataBaseHelper
import com.example.learningproject.dataBase.dataModel.TeacherDataModel

class TeacherDAO(
    private val accessDataBase: DataBaseHelper
) {
    private val list = ArrayList<TeacherDataModel>()
    fun insertTeacher(teacher: TeacherDataModel): Boolean{
        val writeDataBase = accessDataBase.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DataBaseHelper.TEACHER_NAME, teacher.teacherName)
        contentValues.put(DataBaseHelper.TEACHER_FAMILY, teacher.teacherFamily)
        contentValues.put(DataBaseHelper.TEACHER_NATIONAL_CODE, teacher.teacherNationalCode)
        val insertDataResult =
            writeDataBase.insert(DataBaseHelper.TEACHER_TABLE, null, contentValues)
        writeDataBase.close()
        return insertDataResult > 0
    }
    fun selectAll(): ArrayList<TeacherDataModel> {
        val readDataBase = accessDataBase.readableDatabase
        val sqlQuery = "SELECT * FROM ${DataBaseHelper.TEACHER_TABLE}"
        val cursor = readDataBase.rawQuery(sqlQuery, null)
        getData(cursor)
        readDataBase.close()
        return list
    }
    private fun getData(cursor: Cursor) {
        list.clear()
        if (cursor.moveToFirst()) {
            do {
                val teacherId = cursor.getInt(0)
                val teacherName = cursor.getString(1)
                val teacherFamily = cursor.getString(2)
                val teacherNationalCode = cursor.getString(3)
                list.add(TeacherDataModel(teacherId, teacherName, teacherFamily, teacherNationalCode))
            } while (cursor.moveToNext())
        }
        cursor.close()
    }
}