package com.example.silvi.contactapplication

internal class Contact(var name: String, var phone: String, var email: String) {

    // Clase Contact devuelve info del contacto.
    override fun toString(): String {
        return " $name  $phone"
    }

}