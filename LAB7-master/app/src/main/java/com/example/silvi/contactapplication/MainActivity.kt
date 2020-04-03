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
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.AdapterView.OnItemClickListener





internal class MainActivity : AppCompatActivity() {
    lateinit var  contactsList: RecyclerView
    lateinit var  glm: GridLayoutManager
    lateinit var  adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Crear un link entre el listview y el adapter
        contactsList = findViewById(R.id.allContacts);
        glm = GridLayoutManager(this,1)
        contactsList.layoutManager=glm

        val adapter = ContactAdapter(this@MainActivity,ContactApplication.contacts)
        allContacts.adapter = adapter

        //Crear un nuevo contacto
        newContact.setOnClickListener{
            val intent: Intent = Intent(this, NewContact::class.java);
            startActivity(intent);
            finish();

        }






    }

}
