package com.example.mypersonalapplab4.Application

import android.app.Application
import android.view.View
import android.webkit.WebView
import kotlinx.android.synthetic.*;
/*  Silvio Orozco
    Lab4
    Mi Aplicacion de mis proyectos
    31012019*/
class MyApplication: Application() {
    //Variables para cambio de fragments.
    companion object {
        lateinit var nameGit:String
        lateinit var urlGit:String


    }
}