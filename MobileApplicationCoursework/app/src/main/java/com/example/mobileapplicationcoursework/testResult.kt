package com.example.mobileapplicationcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.mobileapplicationcoursework.Model.DataBaseHelper

class testResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)

        val dbHelper = DataBaseHelper(this)

        var lastS = dbHelper.getAllStudents().last()

        findViewById<TextView>(R.id.txtSName).text = "Name: \n${lastS.Name}"
        findViewById<TextView>(R.id.txtResults).text = "Grade: \n${lastS.Grade}"
        findViewById<TextView>(R.id.txtDate).text = "Date Taken: \n${lastS.dateTaken}"

    }

    fun backToStart(view: View){
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

}