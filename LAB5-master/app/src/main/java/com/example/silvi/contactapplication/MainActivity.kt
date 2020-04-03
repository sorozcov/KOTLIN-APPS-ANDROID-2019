package com.example.silvi.contactapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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
            ContactApplication.id=position;
            val intent: Intent = Intent(this, ViewContact()::class.java)
            startActivity(intent)
            finish()
        }

        allContacts.isLongClickable = true
        //Agrega elementos en long click
        allContacts.setOnItemLongClickListener(object : AdapterView.OnItemLongClickListener {

            override fun onItemLongClick(
                arg0: AdapterView<*>, v: View,
                index: Int, arg3: Long
            ): Boolean {
                //Elimina solo un elemento
                Toast.makeText(
                    this@MainActivity,
                    "Contacto ha sido eliminado: ${ContactApplication.contacts.get(index)}",
                    Toast.LENGTH_SHORT
                ).show();
                ContactApplication.contacts.removeAt(index)
                adapter.notifyDataSetChanged()
                return false
            }
        })




    }

}
