package com.example.silvi.contactapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class EmailBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(context, "Nuevo contacto creado. ", Toast.LENGTH_SHORT).show();
    }
}