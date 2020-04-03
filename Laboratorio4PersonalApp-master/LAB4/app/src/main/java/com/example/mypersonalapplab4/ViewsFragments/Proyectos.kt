package com.example.mypersonalapplab4.ViewsFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypersonalapplab4.Application.MyApplication
import com.example.mypersonalapplab4.R
import kotlinx.android.synthetic.main.proyectos.*

/*Fragment de los proyectos realizados*/
class Proyectos : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.proyectos, container, false)
    }

    //Dependiendo del boton envia un url diferente para ser cargado en el siguiente fragment de GITPROYECTO
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Proyectos"
        lab2.setOnClickListener {
            var fragment: Fragment = GitProyecto()
            fragmentManager?.beginTransaction()?.replace(R.id.content_frame, fragment)
                ?.commit()
            MyApplication.nameGit =lab2.text.toString()
            MyApplication.urlGit ="https://github.com/sorozcov/lab2"
        }
        lab3.setOnClickListener {
            var fragment: Fragment = GitProyecto()
            fragmentManager?.beginTransaction()?.replace(R.id.content_frame, fragment)
                ?.commit()
            MyApplication.nameGit =lab3.text.toString()
            MyApplication.urlGit ="https://github.com/sorozcov/Lab3Contactos.git"
        }
    }
}