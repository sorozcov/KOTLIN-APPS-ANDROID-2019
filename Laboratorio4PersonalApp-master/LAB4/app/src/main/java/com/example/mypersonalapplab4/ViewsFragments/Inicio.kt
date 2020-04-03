package com.example.mypersonalapplab4.ViewsFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/*Fragment de inicio con foto y nombre.*/
class Inicio : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(com.example.mypersonalapplab4.R.layout.inicio, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Inicio"
    }
}