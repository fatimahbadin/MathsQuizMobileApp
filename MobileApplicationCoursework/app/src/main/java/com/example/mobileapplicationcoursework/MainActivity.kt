package com.example.mobileapplicationcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mobileapplicationcoursework.Model.DataBaseHelper
import com.example.mobileapplicationcoursework.Model.Student


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun nextPage(view: View){
        val dbHelper = DataBaseHelper(this)

        if (findViewById<EditText>(R.id.txtStudentName).text.toString() != "") {
            var sName = findViewById<EditText>(R.id.txtStudentName).text.toString()
            var grade = 0
            var dateTaken = " "

            var student = Student(0, sName, grade, dateTaken)

            if (dbHelper.addStudent(student)) {
                Toast.makeText(this, "Student added", Toast.LENGTH_SHORT).show()
                findViewById<EditText>(R.id.txtStudentName).text.clear()
                val intent = Intent(this, testCore::class.java)
                startActivity(intent)
            } else Toast.makeText(this, "Student not added", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
        }
    }

    fun adminLoginPage(view: View){
        val intent = Intent(this, AdminLogin::class.java)
        startActivity(intent)
    }

    }
