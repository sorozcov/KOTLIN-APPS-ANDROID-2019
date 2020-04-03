package com.example.silvi.contactapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_contact.*
import kotlinx.android.synthetic.main.activity_view_contact.*

internal class ViewContact() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        name.text=ContactApplication.contactSelected.name.toUpperCase()
        email.text=ContactApplication.contactSelected.email
        phone.text=ContactApplication.contactSelected.phone
        imageContactView.setImageBitmap(ContactApplication.contactSelected.image);

        goBack1.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
            finish();

        }
        editContact.setOnClickListener{
            ContactApplication.editContact=true;
            val intent: Intent = Intent(this, NewContact::class.java);
            startActivity(intent);
            finish();


        }
        phone.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${phone.text.toString()}")
            startActivity(intent)

        }
        email.setOnClickListener{
            val mailto = "mailto:${email.text.toString()}" +
                    "?cc=" + "" +
                    "&subject=" + Uri.encode("Correo desde mi ContactApp.") +
                    "&body=" + Uri.encode("Mi nombre es ${name.text.toString()} y mi teléfono es ${phone.text.toString()}")

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse(mailto)
            startActivity(emailIntent)

        }

    }


}
