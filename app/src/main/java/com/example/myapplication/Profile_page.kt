package com.example.myapplication

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

class Profile_page : AppCompatActivity() {


    private var profile_btn:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)
        profile_btn=findViewById(R.id.profile_btn)
        val profile_email:TextView=findViewById(R.id.profile_email)
        val profile_password:TextView=findViewById(R.id.profile_password)
        val profile_dob:TextView=findViewById(R.id.profile_dob)
        val bundle=intent.extras
        if(bundle!=null)
        {
            profile_email.text=bundle.getString("email")
            profile_password.text=bundle.getString("password")
            profile_dob.text=bundle.getString("dob")
        }
        profile_btn?.setOnClickListener{
            pickimage()
        }



    }

    private fun pickimage() {
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == RESULT_OK) {
           val img:ImageView=findViewById(R.id.profile_img)
            img.setImageURI(data?.data)
        }
    }

}