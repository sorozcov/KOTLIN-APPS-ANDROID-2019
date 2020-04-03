package com.example.silvi.lab2restaurante

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import android.widget.AdapterView


//Actividad de menu
class MENU : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //Crear un link entre el listview y el adapter
        val adapter = ArrayAdapter<String>(this, R.layout.listviews, MyApplication.menu.myOrder)

        restaurantMenu.adapter = adapter
        //Agrega elementos a la orden
        restaurantMenu.setOnItemClickListener { parent, view, position, id ->

            MyApplication.userOrder.myOrder.add(MyApplication.menu.myOrder.get(position))
            Toast.makeText(this@MENU, "Elemento agregado a la orden ${MyApplication.menu.myOrder.get(position)}", Toast.LENGTH_SHORT).show();

        }

        //Regresa al inicio
        mainButton1.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish();

        }

    }


}
