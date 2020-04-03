package com.example.silvi.contactapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.View
import kotlinx.android.synthetic.main.activity_new_contact.contactImage
import java.sql.Types.NULL

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object {
        //Nombre de la Base de Datos
        val DATABASE_VER=1;
        val DATABASE_NAME = "Application.db"

        // Creamos la tabla
        val TABLE_NAME="Contactos"
        val COL_ID="Id"
        val COL_NAME="Name"
        val COL_PHONE="Phone"
        val COL_EMAIL="Email"
        val COL_IMAGE="Image"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY:String = ("CREATE TABLE $TABLE_NAME  ($COL_ID INTEGER PRIMARY KEY ,$COL_NAME TEXT, $COL_PHONE  TEXT, $COL_EMAIL TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val Contacts:List<Contact>
        get(){
            val FirstContacts = ArrayList<Contact>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery,null)
            if(cursor.moveToFirst()){
                do{
                    var name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    var email = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    var phone = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    var image:BitmapDrawable=(R.drawable.subir) as BitmapDrawable;
                    var imageBitmap:Bitmap = image.bitmap
                    val contactSelected = Contact(name,email,phone,imageBitmap);
                }while(cursor.moveToNext())
            }
            return FirstContacts
        }
        fun addContact(){
            val a=0;
        }

}