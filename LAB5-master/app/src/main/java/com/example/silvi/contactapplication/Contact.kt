package com.example.silvi.contactapplication

import android.graphics.Bitmap

class Contact(var name: String, var phone: String, var email: String,var  image: Bitmap) {

    // Clase Contact devuelve info del contacto.
    override fun toString(): String {
        return " $name  $phone"
    }

    }