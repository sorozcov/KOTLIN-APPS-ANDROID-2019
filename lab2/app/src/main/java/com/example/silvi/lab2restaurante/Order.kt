package com.example.silvi.lab2restaurante

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_order.*
//Orden
class Order : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val adapter = ArrayAdapter<String>(this, R.layout.listviews, MyApplication.userOrder.myOrder)

        orderList.adapter = adapter
        orderList.isLongClickable = true
        //Agrega elementos en long click
        orderList.setOnItemLongClickListener(object : AdapterView.OnItemLongClickListener {

            override fun onItemLongClick(
                arg0: AdapterView<*>, v: View,
                index: Int, arg3: Long
            ): Boolean {
                //Elimina solo un elemento
                makeText(this@Order, "Elemento eliminado de la orden ${MyApplication.userOrder.myOrder.get(index)}", LENGTH_SHORT).show();
                MyApplication.userOrder.myOrder.removeAt(index)
                adapter.notifyDataSetChanged()
                return false
            }
        })

    //Regresa al inicio
        mainButton2.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish();
        }

        //Envia pedido
        sendOrder.setOnClickListener{

            makeText(this@Order, "Pedido realizado exitosamente", LENGTH_SHORT).show();
        }

        //Elimina el pedido completo
        deleteOrder.setOnClickListener{
            MyApplication.userOrder.myOrder.clear()
            adapter.notifyDataSetChanged()
            makeText(this@Order, "Pedido ha sido limpiada exitosamente", LENGTH_SHORT).show();
        }
    }
}
