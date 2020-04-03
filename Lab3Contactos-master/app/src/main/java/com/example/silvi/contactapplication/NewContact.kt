package com.example.silvi.contactapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_contact.*
import kotlinx.android.synthetic.main.activity_view_contact.*
import java.nio.file.Files.delete




class NewContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        goBack2.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish();

        }
        //Agregar nuevo contacto al menu.
        createContact.setOnClickListener{
                if ((namec.text.toString())=="" || phonec.text.toString().length!=8 || (emailc.text.toString()=="")){
                    // Initialize a new instance of
                    val builder = AlertDialog.Builder(this@NewContact)

                    // Enviar alerta
                    builder.setTitle("Error")

                    // Mostrar mensaje de alerta si los datos no son validos
                    builder.setMessage("Error en los datos ingresados. No se pudo guardar contacto.")
                    builder.setPositiveButton("Ok"){dialog, which ->

                    }

                    builder.show()

                }else{
                    //Crear contacto
                    var contacto =  Contact(namec.text.toString(),phonec.text.toString(),emailc.text.toString())
                    ContactApplication.contacts.add(contacto)
                    Toast.makeText(this@NewContact, "Nuevo contacto creado. ", Toast.LENGTH_SHORT).show();
                    goBack2.callOnClick()

                }

        }
    }




}
