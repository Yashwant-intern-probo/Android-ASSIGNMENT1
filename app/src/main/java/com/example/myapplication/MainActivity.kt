package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit_email:EditText=findViewById(R.id.edit_email)
        val edit_password:EditText=findViewById(R.id.edit_password)
        val edit_confirm:EditText=findViewById(R.id.edit_confirmpass)
        val txt_date:TextView=findViewById(R.id.txt_date)
        val date_btn:ImageButton=findViewById(R.id.date_btn)
        val btn:Button=findViewById(R.id.signup_btn)

        date_btn.setOnClickListener{
            val c=Calendar.getInstance()
            val year=c.get(Calendar.YEAR)
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)

            val calender_dialog=DatePickerDialog(
                this,{
                    view,m_year,m_month,m_day->
                    txt_date.text=""+m_day+"/"+(m_month+1)+"/"+m_year
                },year,month,day
            )
            calender_dialog.show()


        }

        btn.setOnClickListener{
            if(edit_email.text.toString().isEmpty() or edit_password.text.toString().isEmpty() or edit_confirm.text.toString().isEmpty() or txt_date.text.toString().equals("Date")
            )
            {
                Toast.makeText(MainActivity@this,"plese enter all the details",Toast.LENGTH_SHORT).show()
            }
            else{
                val password=edit_password.text.toString()
                val confirmpass=edit_confirm.text.toString()
                val email=edit_email.text.toString()
                val dob=txt_date.text.toString()
                if(!password.equals(confirmpass))
                {
                    Toast.makeText(MainActivity@this,"PASSWORD DOES NOT MATCH",Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent=Intent(MainActivity@this,Profile_page::class.java)
                    val bundle=Bundle()
                    bundle.putString("email",email)
                    bundle.putString("password",password)
                    bundle.putString("confirm",confirmpass)
                    bundle.putString("dob",dob)
                    intent.putExtras(bundle)
                    startActivity(intent)
                    finish()
                }
            }

        }

    }
}