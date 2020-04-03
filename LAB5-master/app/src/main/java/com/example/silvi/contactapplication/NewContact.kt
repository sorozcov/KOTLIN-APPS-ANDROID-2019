package com.example.silvi.contactapplication

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_contact.*
import kotlinx.android.synthetic.main.activity_view_contact.*
import java.nio.file.Files.delete
import android.provider.MediaStore.Images.Media.getBitmap
import android.graphics.drawable.BitmapDrawable
import android.text.Editable
import android.view.View
import android.widget.EditText


class NewContact : AppCompatActivity() {
    // PICK_PHOTO_CODE is a constant integer
    val PICK_PHOTO_CODE = 1046
    override fun onCreate(savedInstanceState: Bundle?) {
        var RESULT_LOAD_IMAGE:Int =1;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)
        if(ContactApplication.editContact==true){

            namec.text =Editable.Factory.getInstance().newEditable(ContactApplication.contactSelected.name)
            emailc.text =Editable.Factory.getInstance().newEditable(ContactApplication.contactSelected.email)
            phonec.text =Editable.Factory.getInstance().newEditable(ContactApplication.contactSelected.phone)

            contactImage.setImageBitmap(ContactApplication.contactSelected.image);
            createContact.text = "Editar Contacto";
        }
        contactImage.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )

            // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
            // So as long as the result is not null, it's safe to use the intent.
            if (intent.resolveActivity(packageManager) != null) {
                // Bring up gallery to select a photo
                startActivityForResult(intent, PICK_PHOTO_CODE)
            }
        }
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
                    val drawable = contactImage.getDrawable() as BitmapDrawable
                    val contactI:Bitmap = drawable.bitmap
                    if(ContactApplication.editContact==false) {
                        var contacto =
                            Contact(namec.text.toString(), phonec.text.toString(), emailc.text.toString(), contactI)
                        ContactApplication.contacts.add(contacto)
                        Toast.makeText(this@NewContact, "Nuevo contacto creado. ", Toast.LENGTH_SHORT).show();

                    }else{
                        ContactApplication.contacts[ContactApplication.id].name=namec.text.toString().toUpperCase()
                        ContactApplication.contacts[ContactApplication.id].phone=phonec.text.toString()
                        ContactApplication.contacts[ContactApplication.id].email=emailc.text.toString()
                        ContactApplication.contacts[ContactApplication.id].image=contactI
                        Toast.makeText(this@NewContact, "Contacto ha sido editado. ", Toast.LENGTH_SHORT).show();

                    }
                }
            ContactApplication.editContact=false;
            goBack2.callOnClick()

        }




    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //https://github.com/codepath/android_guides/wiki/Accessing-the-Camera-and-Stored-Media
        if (data != null) {
            var photoUri:Uri = data.getData();
            // Do something with the photo based on Uri
            var selectedImage:Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri);
            // Load the selected image into a preview

            contactImage.setImageBitmap(selectedImage);
            Toast.makeText(this@NewContact, "Imagen cargada con éxito.. ", Toast.LENGTH_SHORT).show();
        }
    }




}
