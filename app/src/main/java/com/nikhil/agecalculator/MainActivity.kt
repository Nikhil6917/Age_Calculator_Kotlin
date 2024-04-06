package com.nikhil.agecalculator

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var selectDate : TextView
    private lateinit var btnCalc : Button
    private lateinit var showAge : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectDate = findViewById(R.id.selectDate)
        btnCalc = findViewById(R.id.calBtn)
        showAge = findViewById(R.id.showAge)
    }

    fun selectDate(view : View){
        var c = Calendar.getInstance()
        var cDay = c.get((Calendar.DAY_OF_MONTH))
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        val calendarDialog = DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            cDay = dayOfMonth
            cMonth = month
            cYear = year
            btnCalc.visibility = View.VISIBLE
            textMessage("You select Date : $cDay/${cMonth+1}/$cYear")
            btnCalc.setOnClickListener {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                val age = currentYear - cYear
                showAge.visibility = View.VISIBLE
                showAge.text = "Ypur age is $age year"
                textMessage("Your age is $age year")
            }
            selectDate.text = "Your select date is : $cDay/${cMonth+1}/$cYear"
        },cYear,cMonth,cDay)
        calendarDialog.show()
    }
    private fun textMessage(s: String){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}