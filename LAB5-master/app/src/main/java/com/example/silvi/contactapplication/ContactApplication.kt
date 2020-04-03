package com.example.silvi.contactapplication

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_view_contact.*
import kotlinx.android.synthetic.main.*

//Aplicacion de contactos Silvio Orozco.
internal class ContactApplication : Application() {

    companion object {
        var contacts = arrayListOf<Contact>();
        var id=0;
         var editContact = false;
         lateinit var contactSelected:Contact;
    }
}