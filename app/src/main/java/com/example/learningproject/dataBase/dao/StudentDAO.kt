package com.example.learningproject.dataBase.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteException
import android.util.Log
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
    fun deleteById(studentId: String): Boolean {
        val writDataBase = accessDataBase.writableDatabase
        val deleteResult = writDataBase.delete(
            DataBaseHelper.STUDENT_TABLE,
            "${DataBaseHelper.STUDENT_ID} = ?",
            arrayOf(studentId)
        )
        writDataBase.close()
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
        list.clear()
        try {
            if (cursor.moveToFirst()) {
                do {
                    val id: Int =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.STUDENT_ID))
                    val studentName: String =
                        cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.STUDENT_NAME))
                    val studentFamily: String =
                        cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.STUDENT_FAMILY))
                    val studentTeacherId: Int =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.STUDENT_TEACHER_ID))
                    val studentAge: Int =
                        cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.STUDENT_AGE))
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
        } catch (e: IllegalArgumentException) {
            Log.e("ILLEGAL_ARGUMENT_EXCEPTION", e.message.toString())
        }
    }
}