package com.example.mypersonalapplab4.ViewsFragments

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import com.example.mypersonalapplab4.R

/*Main Activity donde se cargan y se reemplazan los distintos fragmentos.*/
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        var fragment: Fragment = Inicio()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()

        /*Se han establecido caracteristicas iniciales junto con el fragment*/
    }

    //Depende de si esta en inicio, si esta en el drawer o si esta en otra activity back pressed se ejecuta diferente.
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else if (supportFragmentManager.findFragmentById(R.id.content_frame)  is Inicio) {
            super.onBackPressed()
        }else{
            var fragment: Fragment = Inicio()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    /*Dependiendo del item escogido en el menu, se reemplaza por un fragmento distinto.*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        //creating fragment object
        var fragment: Fragment = Inicio()
        when (item.itemId) {
            R.id.nav_inicio -> {
                fragment = Inicio()
            }
            R.id.nav_proyectos -> {
                fragment = Proyectos()
            }
            R.id.nav_direccion -> {
                fragment = Mapas()
            }




        }
        //replacing the fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



}
