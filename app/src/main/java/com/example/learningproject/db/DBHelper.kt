package com.example.learningproject.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        //Data Base Info
        private const val DB_NAME = "Test_school.db"
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
        const val TEACHER_AGE = "Age"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS $TEACHER_TABLE (" +
                "$TEACHER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$TEACHER_NAME VARCHAR(50)," +
                "$TEACHER_FAMILY VARCHAR(75)," +
                "$TEACHER_NATIONAL_CODE VARCHAR(10)," +
                "$TEACHER_AGE INTEGER)")

        db?.execSQL("CREATE TABLE IF NOT EXISTS $STUDENT_TABLE (" +
                "$STUDENT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$STUDENT_NAME VARCHAR(50)," +
                "$STUDENT_FAMILY VARCHAR(75)," +
                "$STUDENT_TEACHER_ID INTEGER," +
                "$STUDENT_AGE INTEGER CHECK ($STUDENT_AGE > 18)," +
                "FOREIGN KEY ($STUDENT_TEACHER_ID) REFERENCES $TEACHER_TABLE ($TEACHER_ID))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}