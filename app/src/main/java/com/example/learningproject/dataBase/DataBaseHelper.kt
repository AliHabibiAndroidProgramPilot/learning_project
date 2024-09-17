package com.example.learningproject.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        //Data Base Info
        private const val DB_NAME = "Test_school.dataBase"
        private const val DB_VERSION = 1
        //Student Table
        const val STUDENT_TABLE = "Student"
        const val STUDENT_ID = "Id"
        const val STUDENT_NAME = "Name"
        const val STUDENT_FAMILY = "Family"
        const val STUDENT_TEACHER_ID = "Teacher_Id"
        const val STUDENT_AGE = "Age"
        //Teacher Table
        const val TEACHER_TABLE = "Teacher"
        const val TEACHER_ID = "Id"
        const val TEACHER_NAME = "Name"
        const val TEACHER_FAMILY = "Family"
        const val TEACHER_NATIONAL_CODE = "National_Code"
    }

    override fun onCreate(dataBase: SQLiteDatabase?) {
        dataBase?.execSQL("CREATE TABLE IF NOT EXISTS $TEACHER_TABLE (" +
                "$TEACHER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$TEACHER_NAME VARCHAR(50)," +
                "$TEACHER_FAMILY VARCHAR(75)," +
                "$TEACHER_NATIONAL_CODE VARCHAR(10))")

        dataBase?.execSQL("CREATE TABLE IF NOT EXISTS $STUDENT_TABLE (" +
                "$STUDENT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$STUDENT_NAME VARCHAR(50)," +
                "$STUDENT_FAMILY VARCHAR(75)," +
                "$STUDENT_TEACHER_ID INTEGER," +
                "$STUDENT_AGE INTEGER CHECK ($STUDENT_AGE > 18)," +
                "FOREIGN KEY ($STUDENT_TEACHER_ID) REFERENCES $TEACHER_TABLE ($TEACHER_ID))")
    }

    override fun onUpgrade(dataBase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Matters which Table Must Be Delete First
        dataBase?.execSQL("DROP TABLE IF EXISTS $STUDENT_TABLE")
        dataBase?.execSQL("DROP TABLE IF EXISTS $TEACHER_TABLE")
        onCreate(dataBase)
    }
}