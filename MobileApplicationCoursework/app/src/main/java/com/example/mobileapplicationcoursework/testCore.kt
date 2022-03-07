package com.example.mobileapplicationcoursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.mobileapplicationcoursework.Model.*
import com.google.android.material.chip.ChipGroup
import java.util.*
import kotlin.collections.ArrayList

class testCore : AppCompatActivity() {

    lateinit var myTest: Test
    lateinit var topicList: ArrayList<Topic>
    lateinit var questionList: ArrayList<Question>
    lateinit var answerList: ArrayList<Answer>

    lateinit var q1: ArrayList<Question>
    lateinit var q2: ArrayList<Question>
    lateinit var q3: ArrayList<Question>
    lateinit var q4: ArrayList<Question>
    lateinit var q5: ArrayList<Question>
    lateinit var q6: ArrayList<Question>
    lateinit var q7: ArrayList<Question>

    lateinit var qt: ArrayList<Question>
    lateinit var aq: ArrayList<Answer>

    lateinit var dbHelper: DataBaseHelper

    var qNo = 1   // current number of question
    var sGrade = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_core)

        myTest = Test(this)
        topicList = myTest.get_TopicList() // Get all topics
        questionList = myTest.get_QuestionList()
        answerList = myTest.get_AnswerList()
        dbHelper = DataBaseHelper(this)

        q1 = ArrayList()
        q2 = ArrayList()
        q3 = ArrayList()
        q4 = ArrayList()
        q5 = ArrayList()
        q6 = ArrayList()
        q7 = ArrayList()

        qt = ArrayList()
        aq = ArrayList()

        for (i in questionList){
            when (i.TopicID) {
                1 -> q1.add(i)
                2 -> q2.add(i)
                3 -> q3.add(i)
                4 -> q4.add(i)
                5 -> q5.add(i)
                6 -> q6.add(i)
                7 -> q7.add(i)
            }
        }


        var qt1 = q1.get((0..5).random())
        qt.add(qt1)
        q1.remove(qt1)

        var qt2 = q2.get((0..5).random())
        qt.add(qt2)
        q2.remove(qt2)

        var qt3 = q3.get((0..5).random())
        qt.add(qt3)
        q3.remove(qt3)

        var qt4 = q4.get((0..5).random())
        qt.add(qt4)
        q4.remove(qt4)

        var qt5 = q5.get((0..5).random())
        qt.add(qt5)
        q5.remove(qt5)

        var qt6 = q6.get((0..5).random())
        qt.add(qt6)
        q6.remove(qt6)

        var qt7 = q7.get((0..5).random())
        qt.add(qt7)
        q7.remove(qt7)



        var qt8 = q1.get((0..4).random())
        qt.add(qt8)
        q1.remove(qt8)

        var qt9 = q2.get((0..4).random())
        qt.add(qt9)
        q2.remove(qt9)

        var qt10 = q3.get((0..4).random())
        qt.add(qt10)
        q3.remove(qt10)

        var qt11 = q4.get((0..4).random())
        qt.add(qt11)
        q4.remove(qt11)

        var qt12 = q5.get((0..4).random())
        qt.add(qt12)
        q5.remove(qt12)

        var qt13 = q6.get((0..4).random())
        qt.add(qt13)
        q6.remove(qt13)

        var qt14 = q7.get((0..4).random())
        qt.add(qt14)
        q7.remove(qt14)

        nextQuestion()
        findViewById<TextView>(R.id.txtQuestionNo).text = "Question: $qNo"
    }

   // fun nextQ(view: View) {

        /*  Updated on 10/1/2022 *********************************/
        /*lateinit var ra1 : Answer
        lateinit var ra2 : Answer
        lateinit var ra3 : Answer*/
        /**********************************************************/

        fun nextQ(view: View) {

            /*when(view.id) {
                R.id.btnAnswer1 -> when (AnswerIsCorrect.values()[ra1.IsCorrect]) {
                    AnswerIsCorrect.Correct -> sGrade++
                    AnswerIsCorrect.Incorrect -> sGrade = sGrade
                }

                R.id.btnAnswer2 -> when (AnswerIsCorrect.values()[ra2.IsCorrect]) {
                    AnswerIsCorrect.Correct -> sGrade++
                    AnswerIsCorrect.Incorrect -> sGrade = sGrade
                }

                R.id.btnAnswer3 -> when (AnswerIsCorrect.values()[ra3.IsCorrect]) {
                    AnswerIsCorrect.Correct -> sGrade++
                    AnswerIsCorrect.Incorrect -> sGrade = sGrade
                }
            }*/

        if (qNo >= 14){
            findViewById<TextView>(R.id.txtQuestion).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.txtQuestionNo).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer1).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer3).visibility = View.INVISIBLE
        }
            nextQuestion()
        qNo++
        findViewById<TextView>(R.id.txtQuestionNo).text = "Question: $qNo"
    }


    fun nextQuestion() {

        if (qNo >= 14){
            findViewById<TextView>(R.id.txtQuestion).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.txtQuestionNo).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer1).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer2).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.btnAnswer3).visibility = View.INVISIBLE
        }

        if (qNo < 14){
            var q = qt.random()

            var ia : ArrayList<Answer> = ArrayList()
            var ca : ArrayList<Answer> = ArrayList()
           // var ra : ArrayList<Answer> = ArrayList()
            var a : ArrayList<Answer> = ArrayList(dbHelper.getAllAnswers(q.ID))

            findViewById<TextView>(R.id.txtQuestion).text = q.Questions

            for (i in a) {
                if (i.QuestionID == q.ID) {
                    aq.add(i)
                }
                when (AnswerIsCorrect.values()[i.IsCorrect]) {
                    AnswerIsCorrect.Correct -> ca.add(i)
                    AnswerIsCorrect.Incorrect -> ia.add(i)
                    //AnswerIsCorrect.Incorrect -> ia.add(i)
                }
            }


            var ia1 = ia.get((0..3).random())
            ia.remove(ia1)
            var ia2 = ia.get((0..2).random())

            var ra = arrayListOf(ca.get(0), ia1, ia2)/*.shuffled()*/

            var ra1 = ra.get(0)
            var ra2 = ra.get(1)
            var ra3 = ra.get(2)

            findViewById<Button>(R.id.btnAnswer1).text = ra1.Answers
            findViewById<Button>(R.id.btnAnswer2).text = ra2.Answers
            findViewById<Button>(R.id.btnAnswer3).text = ra3.Answers

            var btnGroup = findViewById<ChipGroup>(R.id.btnGroup)
            var btnArray = ArrayList<Button> ()

            btnArray.add(findViewById<Button>(R.id.btnAnswer1))
            btnArray.add(findViewById<Button>(R.id.btnAnswer2))
            btnArray.add(findViewById<Button>(R.id.btnAnswer3))

            btnArray.shuffle()

            if (findViewById<Button>(R.id.btnAnswer1).isPressed){
                sGrade ++
            } else {
                sGrade = sGrade
            }

            btnGroup.removeAllViews()

            for(rb in btnArray) {
                btnGroup.addView(rb)
            }


            /*var btn1 = findViewById<Button>(R.id.btnAnswer1)
            var btn2 = findViewById<Button>(R.id.btnAnswer2)
            var btn3 = findViewById<Button>(R.id.btnAnswer3)*/

           /*if (btn1.isPressed){
                when (AnswerIsCorrect.values()[ra1.IsCorrect]) {
                    AnswerIsCorrect.Correct -> sGrade++
                    AnswerIsCorrect.Incorrect -> sGrade = sGrade
                }
            } else if (btn2.isPressed){
               when (AnswerIsCorrect.values()[ra2.IsCorrect]) {
                   AnswerIsCorrect.Correct -> sGrade++
                   AnswerIsCorrect.Incorrect -> sGrade = sGrade
               }
            } else if (btn3.isPressed) {
               when (AnswerIsCorrect.values()[ra3.IsCorrect]) {
                   AnswerIsCorrect.Correct -> sGrade++
                   AnswerIsCorrect.Incorrect -> sGrade = sGrade
               }
           } else {
                sGrade = sGrade
            }*/

            /*if (btn1.isPressed && (btn1.text.toString() == ca.get(0).Answers)){
                sGrade++
            } else if (btn2.isPressed && (btn2.text.toString() == ca.get(0).Answers)) {
                sGrade++
            } else if (btn3.isPressed && (btn3.text.toString() == ca.get(0).Answers)) {
                sGrade++
            } else {
                sGrade = sGrade
            }*/

               // findViewById<TextView>(R.id.textViewsize).text = "grade = ${sGrade.toString()}"

            qt.remove(q)

        } else {
            val intent = Intent(this, testResult::class.java)
            startActivity(intent)
        }


        fun updateStudentDetails(studentID : Int, studentName : String, gradeNew : Int, dateCompleted : String){
            val newStudent = Student(studentID, studentName, gradeNew, dateCompleted)
            dbHelper.updateStudent(newStudent)
        }

        var getStudent = dbHelper.getAllStudents().last()

        var currentDate : String = Calendar.getInstance().time.toString()

        updateStudentDetails(getStudent.ID, getStudent.Name, sGrade, currentDate)

    }

}

