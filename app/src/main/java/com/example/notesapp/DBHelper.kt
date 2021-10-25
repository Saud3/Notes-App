package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,"details.db",null,1) {

    var sqlLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db !=null)
            db.execSQL("create table messages (Note text)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedata(notes: String){
        val cv = ContentValues()
        cv.put("Note",notes)

        sqlLiteDatabase.insert("messages",null,cv)
    }
}