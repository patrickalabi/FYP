package com.project.grittycc.models

data class ExamModel(
    val questionNo: String,
    val questionsText: String,
    val questionsOptions: ArrayList<String>,
    val correctAnswer: String,
    val selectedAnswer: String = ""
)