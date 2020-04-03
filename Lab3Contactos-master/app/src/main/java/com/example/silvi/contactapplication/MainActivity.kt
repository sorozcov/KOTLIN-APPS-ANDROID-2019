package com.example.silvi.contactapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_contact.*
import kotlinx.android.synthetic.main.activity_view_contact.view.*

internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Crear un link entre el listview y el adapter
        val adapter = ArrayAdapter<Contact>(this, R.layout.listviews, ContactApplication.contacts)
        allContacts.adapter = adapter

        //Crear un nuevo contacto
        newContact.setOnClickListener{
            val intent: Intent = Intent(this, NewContact::class.java);
            startActivity(intent);
            finish();

        }

        //Ver el contacto seleccionado
        allContacts.setOnItemClickListener { parent, view, position, id ->
            ContactApplication.contactSelected=(ContactApplication.contacts.get(position));
            val intent: Intent = Intent(this, ViewContact()::class.java)
            startActivity(intent)
            finish()
        }




    }

}
