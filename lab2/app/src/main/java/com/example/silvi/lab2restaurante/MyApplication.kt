package com.example.silvi.lab2restaurante

import android.app.Application
//Silvio Orozco 18282
//Controlador de aplicacion
class MyApplication: Application() {

    companion object {
        var menu = MyMenuOrder(arrayListOf<String>("Pizza", "Pollo","Papas Fritas","Poporopos","Helado","Tacos","Hamburguesa"));
        var userOrder = MyMenuOrder(arrayListOf<String>());
    }

}
