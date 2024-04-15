package com.example.bai22_4_crud_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context,"TUHOCDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // tạo table,column
        db?.execSQL("CREATE TABLE TUHOC(_id integer primary key autoincrement,user TEXT,email TEXT)")
        // Thêm data vào cơ sở dữ liệu
        db?.execSQL("INSERT INTO TUHOC(user,email) values ('mot','mot@mail.com')")
        db?.execSQL("INSERT INTO TUHOC(user,email) values ('hai','hai@mail.com')")
        db?.execSQL("INSERT INTO TUHOC(user,email) values ('ba','ba@mail.com')")
        db?.execSQL("INSERT INTO TUHOC(user,email) values ('tuhoc','tuhoc@mail.com')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}