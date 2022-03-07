package com.example.mobileapplicationcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.mobileapplicationcoursework.Model.Answer
import com.example.mobileapplicationcoursework.Model.DataBaseHelper
import com.example.mobileapplicationcoursework.Model.Question

class Admin : AppCompatActivity() {

    val dbHelper : DataBaseHelper = DataBaseHelper(this)

    var QuestionTopicID : Int = 0
    var isAnsCorrect : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
    }

    fun addQuestionAnswer(view : View){

        val adminTopicT = findViewById<EditText>(R.id.editTextAdminTopic).text
        val adminTopic = findViewById<EditText>(R.id.editTextAdminTopic).text.toString().toInt()

        val adminQ = findViewById<EditText>(R.id.editTextAdminQuestion).text.toString()
        val adminA1 = findViewById<EditText>(R.id.editTextAdminAns1).text.toString()
        val adminA2 = findViewById<EditText>(R.id.editTextAdminAns2).text.toString()
        val adminA3 = findViewById<EditText>(R.id.editTextAdminAns3).text.toString()
        val adminA4 = findViewById<EditText>(R.id.editTextAdminAns4).text.toString()
        val adminA5 = findViewById<EditText>(R.id.editTextAdminAns5).text.toString()

        if (adminTopicT.length == 0) {
            Toast.makeText(this, "Please enter a topic number", Toast.LENGTH_SHORT).show()
        } else {
            when (adminTopic) {
                1 -> QuestionTopicID = 1
                2 -> QuestionTopicID = 2
                3 -> QuestionTopicID = 3
                4 -> QuestionTopicID = 4
                5 -> QuestionTopicID = 5
                6 -> QuestionTopicID = 6
                7 -> QuestionTopicID = 7
            }
        }

        val cbIsAnsCorrect1 = findViewById<CheckBox>(R.id.cbAns1)
        val cbIsAnsCorrect2 = findViewById<CheckBox>(R.id.cbAns2)
        val cbIsAnsCorrect3 = findViewById<CheckBox>(R.id.cbAns3)
        val cbIsAnsCorrect4 = findViewById<CheckBox>(R.id.cbAns4)
        val cbIsAnsCorrect5 = findViewById<CheckBox>(R.id.cbAns5)


        if (cbIsAnsCorrect1.isChecked){
            isAnsCorrect = 1
        } else if (cbIsAnsCorrect2.isChecked){
            isAnsCorrect = 1
        } else if (cbIsAnsCorrect3.isChecked){
            isAnsCorrect = 1
        } else if (cbIsAnsCorrect4.isChecked){
            isAnsCorrect = 1
        } else if (cbIsAnsCorrect5.isChecked){
            isAnsCorrect = 1
        } else {
            Toast.makeText(this, "Please select the correct answer", Toast.LENGTH_SHORT).show()
        }

        if ((adminQ != "" && adminA1 != "" && adminA2 != "" && adminA3 != "" && adminA4 != "" && adminA5 != "") &&
            (cbIsAnsCorrect1.isChecked || cbIsAnsCorrect2.isChecked || cbIsAnsCorrect3.isChecked ||
                    cbIsAnsCorrect4.isChecked || cbIsAnsCorrect1.isChecked)) {

            var lastQ = dbHelper.getAllQuestions().last().ID
            var lastA = dbHelper.getAllAnswers(adminTopic).last().ID
            val AdminQuestion = Question(lastQ + 1, adminTopic, adminQ)

            if (dbHelper.addAdminQuestion(AdminQuestion)){

                findViewById<EditText>(R.id.editTextAdminQuestion).text.clear()
                Toast.makeText(this, "Question added", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Question not added", Toast.LENGTH_SHORT).show()

            }

            val answer1 = Answer(lastA + 1, lastQ, adminA1, isAnsCorrect)
            val answer2 = Answer(lastA + 1, lastQ, adminA2, isAnsCorrect)
            val answer3 = Answer(lastA + 1, lastQ, adminA3, isAnsCorrect)
            val answer4 = Answer(lastA + 1, lastQ, adminA4, isAnsCorrect)
            val answer5 = Answer(lastA + 1, lastQ, adminA5, isAnsCorrect)

            if (dbHelper.addAdminAnswers(answer1) && dbHelper.addAdminAnswers(answer2) &&
                dbHelper.addAdminAnswers(answer3) && dbHelper.addAdminAnswers(answer4) &&
                dbHelper.addAdminAnswers(answer5)) {

                findViewById<EditText>(R.id.editTextAdminAns1).text.clear()
                findViewById<EditText>(R.id.editTextAdminAns2).text.clear()
                findViewById<EditText>(R.id.editTextAdminAns3).text.clear()
                findViewById<EditText>(R.id.editTextAdminAns4).text.clear()
                findViewById<EditText>(R.id.editTextAdminAns5).text.clear()

                Toast.makeText(this, "Answers added", Toast.LENGTH_SHORT).show()


            } else {
                Toast.makeText(this, "Answers not added", Toast.LENGTH_SHORT).show()
            }


            findViewById<EditText>(R.id.editTextAdminTopic).text.clear()
            cbIsAnsCorrect1.isChecked = false
            cbIsAnsCorrect2.isChecked = false
            cbIsAnsCorrect3.isChecked = false
            cbIsAnsCorrect4.isChecked = false
            cbIsAnsCorrect5.isChecked = false

        } else {
            Toast.makeText(this, "Double check the details", Toast.LENGTH_SHORT).show()
        }

    }

    fun backToStart(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}