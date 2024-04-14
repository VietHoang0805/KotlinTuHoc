package com.example.bai22_2_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper (context: Context) : SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        // Tạo bảng
        p0?.execSQL("CREATE TABLE USERS(USERID Integer PRIMARY KEY AUTOINCREMENT, UNAME TEXT, PWD TEXT )")
        // ADD DATA
        p0?.execSQL("INSERT INTO USERS(UNAME, PWD) VALUES ('VietNeZ','08052004') ")
        p0?.execSQL("INSERT INTO USERS(UNAME, PWD) VALUES ('VietDEMO','220022') ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}