package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class DisplayInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

        //get the values from previous activity
        val getFn:String? = intent.extras!!.getString("fn")
        val getLn:String? = intent.extras!!.getString("ln")
        val getAge:String? = intent.extras!!.getString("age")
        val getBd:String? = intent.extras!!.getString("date")
        val getEmail:String? = intent.extras!!.getString("email")
        val getPn:String? = intent.extras!!.getString("pn")

        //initialize the views to insert the values from the previous activity
        val fName = findViewById<TextView>(R.id.fName) as TextView
        val lName = findViewById<TextView>(R.id.lName) as TextView
        val age = findViewById<TextView>(R.id.age) as TextView
        val bDay = findViewById<TextView>(R.id.bDay) as TextView
        val eMail = findViewById<TextView>(R.id.eMail) as TextView
        val phoneNumber = findViewById<TextView>(R.id.phoneNumber) as TextView

        //append to the views
        fName.append("$getFn")
        lName.append("$getLn")
        age.append("$getAge")
        bDay.append("$getBd")
        eMail.append("$getEmail")
        phoneNumber.append("$getPn")

    }
}