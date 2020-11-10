package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listener for button
        findViewById<Button>(R.id.nextPageBtn).setOnClickListener{getTexts()}

        //listener for switch
        findViewById<Switch>(R.id.phoneNum).setOnClickListener { getPhoneNum(findViewById<Switch>(R.id.phoneNum).isChecked) }

        //listener for seekbar
        findViewById<SeekBar>(R.id.ageBar).setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //initialize the text view to gain access to its contents
                val getAge = findViewById(R.id.ageVal) as TextView
                //set the seekbar progress to the text view
                getAge.setText(progress.toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
    private fun getPhoneNum(status: Boolean){
        //gain access to the Phone Number textfield
        val showTxt:EditText = findViewById<EditText>(R.id.editTextPhone) as EditText

        if(status){
            //if the switch is on, show the textfield
            showTxt.isVisible = true
        }
        else{
            //else hide the textfield
            showTxt.isVisible = false
        }
    }
    private fun getTexts(){
        //get the values from the textfield and textview and return them as String
        val fn = findViewById<EditText>(R.id.fnField).text
        val ln = findViewById<EditText>(R.id.lnField).text
        val email = findViewById<EditText>(R.id.emailField).text
        val age = findViewById<TextView>(R.id.ageVal).text
        val pn = findViewById<EditText>(R.id.editTextPhone).text

        //initialize intent to be passed to the next activity
        val intent = Intent(this, NextActivity::class.java)
        intent.putExtra("fn", fn.toString())
        intent.putExtra("ln", ln.toString())
        intent.putExtra("age", age.toString())
        intent.putExtra("email", email.toString())
        intent.putExtra("pn", pn.toString())
        startActivity(intent)
    }
}
