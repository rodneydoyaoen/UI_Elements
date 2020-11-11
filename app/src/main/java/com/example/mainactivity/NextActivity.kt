package com.example.mainactivity

import android.content.Intent
import android.icu.text.DateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.*
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

var getBd = "01/01/2020"

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        //listener for the button
        findViewById<Button>(R.id.completeBtn).setOnClickListener {compSign()}

        var calendarV = findViewById<CalendarView>(R.id.calendarView)
        calendarV.setOnDateChangeListener{calendarView: CalendarView, year: Int, month: Int, day: Int ->
            getBd = ""+ (month+1)+"/"+day+"/"+year
        }
    }
    private fun compSign() {
        //access the textview to get the date as text

        //initialize intent to pass values from MainActivity into DisplayInfo
        val next = Intent(this, DisplayInfo::class.java)
        val getFn: String? = intent.extras!!.getString("fn")
        val getLn: String? = intent.extras!!.getString("ln")
        val getAge: String? = intent.extras!!.getString("age")
        val getEmail: String? = intent.extras!!.getString("email")
        val getPn: String? = intent.extras!!.getString("pn")

        next.putExtra("fn", getFn.toString())
        next.putExtra("ln", getLn.toString())
        next.putExtra("age", getAge.toString())
        //get the date from textView as String
        next.putExtra("date", getBd)
        next.putExtra("email", getEmail.toString())
        next.putExtra("pn", getPn.toString())

        startActivity(next)
    }
}
