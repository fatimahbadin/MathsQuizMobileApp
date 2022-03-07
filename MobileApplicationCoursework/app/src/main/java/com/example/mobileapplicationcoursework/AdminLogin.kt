package com.example.mobileapplicationcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mobileapplicationcoursework.Model.DataBaseHelper

class AdminLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        val dbHelper = DataBaseHelper(this)

        findViewById<TextView>(R.id.txtAdminNoCheck).text = dbHelper.getAllAdmins().get(0).AdminNumber.toString()
        findViewById<TextView>(R.id.txtAdminPWCheck).text = dbHelper.getAllAdmins().get(0).Password.toString()
    }

    fun adminPage(view: View) {

        val adminNoCheck = findViewById<TextView>(R.id.txtAdminNoCheck).text.toString().toInt()
        val pwCheck = findViewById<TextView>(R.id.txtAdminPWCheck).text.toString().toInt()

        val adminNo = findViewById<EditText>(R.id.txtEAdminNo).text.toString().toInt()
        val adminPW = findViewById<EditText>(R.id.txtEAdminPW).text.toString().toInt()


        if (adminNoCheck == adminNo && pwCheck == adminPW ) {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        } else {
            if (adminNoCheck != adminNo) {
                Toast.makeText(this, "Incorrect Admin Number", Toast.LENGTH_SHORT).show()
            } else if (pwCheck != adminPW) {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "Incorrect Details", Toast.LENGTH_SHORT).show()
        }
    }
}