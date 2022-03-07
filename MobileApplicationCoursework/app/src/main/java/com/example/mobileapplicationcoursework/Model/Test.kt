package com.example.mobileapplicationcoursework.Model

import android.content.Context

class Test(context: Context) {

    private val topicList: ArrayList<Topic>
    private val questionList: ArrayList<Question>
    private val answerList: ArrayList<Answer>
    private val studentList: ArrayList<Student>
    private val adminList: ArrayList<Admin>
    private val dbHelper: DataBaseHelper = DataBaseHelper(context)

    init {

        topicList = dbHelper.getAllTopics()
        questionList = dbHelper.getAllQuestions()
        answerList = dbHelper.getAllAnswers(0)
        studentList = dbHelper.getAllStudents()
        adminList = dbHelper.getAllAdmins()

    }

    fun get_TopicList(): ArrayList<Topic> {
        return topicList
    }

    fun get_QuestionList(): ArrayList<Question> {
        return questionList
    }

    fun get_AnswerList(): ArrayList<Answer>{
        return answerList
    }

    fun get_StudentList(): ArrayList<Student>{
        return studentList
    }

    fun get_Topic(topicId: Int) : String {
        var topic = "Not found"
        for (e in topicList)
            if (e.ID == topicId) {
                topic = e.Topic
                break
            }
        return topic
    }

}