package com.example.silvi.lab2restaurante

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
//Silvio Orozco Vizquerra 18282
//Actividad 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicia otra actividad
        showMenu.setOnClickListener{
            val intent: Intent = Intent(this, MENU::class.java);
            startActivity(intent);
            finish();
        }
        //Muestra la orden
        showOrder.setOnClickListener{
            val intent: Intent = Intent(this, Order::class.java);
            startActivity(intent);
            finish();
        }
    }

}
