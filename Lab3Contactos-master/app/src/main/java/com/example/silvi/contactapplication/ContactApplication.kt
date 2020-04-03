package com.example.silvi.contactapplication

import android.app.Application
//Aplicacion de contactos Silvio Orozco.
internal class ContactApplication : Application() {

    companion object {
        var contacts = arrayListOf<Contact>();
        var contactSelected = Contact("","","");
    }
}