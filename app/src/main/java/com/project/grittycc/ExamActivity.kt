package com.project.grittycc

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.grittycc.models.ExamModel


class ExamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        examsQuestions()

        findViewById<ImageView>(R.id.m_back_icon).setOnClickListener {
            finish()
        }
    }


    private fun examsQuestions() {
        val linearLayout: View = findViewById(R.id.main_layout)

        //Options for Question 1
        val optionsList = ArrayList<String>()
        optionsList.add("Not be limited")
        optionsList.add("Be 8 Characters Maximum")
        optionsList.add("Contain the username")
        optionsList.add("Be easy to remember")
        //Options for Question 2
        val optionsList2 = ArrayList<String>()
        optionsList2.add("Ciphertext")
        optionsList2.add("One-way Hash")
        optionsList2.add("Plaintext")
        //Options for Question 3
        val optionsList3 = ArrayList<String>()
        optionsList3.add("www")
        optionsList3.add("https")
        optionsList3.add("http")
        optionsList3.add("")

        val optionsList4 = ArrayList<String>()
        optionsList4.add("")

        val optionsList5 = ArrayList<String>()
        optionsList5.add("")

        val optionsList6 = ArrayList<String>()
        optionsList6.add("")

        val optionsList7 = ArrayList<String>()
        optionsList7.add("")

        val optionsList8 = ArrayList<String>()
        optionsList8.add("")

        val optionsList9 = ArrayList<String>()
        optionsList9.add("")

        val optionsList10 = ArrayList<String>()
        optionsList10.add("")



        val examModel = ExamModel("Question 01", "Please select the correct answer? " +
                "\n The best password length should ? ", optionsList, "Not be limited")
        val examModel2 = ExamModel("Question No 02", "Please select the correct answer?" +
                "\n Which password storage method isn't recommended?  ", optionsList2, "Plaintext")
        val examModel3 = ExamModel( "Question 03", "Please select the correct answer?" +
                "\n Deceptive Websites tend to forget ______  in the URL." , optionsList3, "https")

        val examModel4 = ExamModel( "Question 04", "Please select the correct answer?" +
                "\n" , optionsList4, "")

        val examModel5 = ExamModel( "Question 05", "Please select the correct answer?" +
                "\n" , optionsList5, "")

        val examModel6 = ExamModel( "Question 06", "Please select the correct answer?" +
                "\n" , optionsList6, "")

        val examModel7 = ExamModel( "Question 07", "Please select the correct answer?" +
                "\n" , optionsList7, "")

        val examModel8 = ExamModel( "Question 08", "Please select the correct answer?" +
                "\n" , optionsList8, "")

        val examModel9 = ExamModel( "Question 09", "Please select the correct answer?" +
                "\n" , optionsList9, "")

        val examModel10 = ExamModel( "Question 10", "Please select the correct answer?" +
                "\n" , optionsList10, "")



        val examsQuestionsList = ArrayList<ExamModel>()
        examsQuestionsList.add(examModel)
        examsQuestionsList.add(examModel2)
        examsQuestionsList.add(examModel3)
        examsQuestionsList.add(examModel4)
        examsQuestionsList.add(examModel5)
        examsQuestionsList.add(examModel6)
        examsQuestionsList.add(examModel7)
        examsQuestionsList.add(examModel8)
        examsQuestionsList.add(examModel9)
        examsQuestionsList.add(examModel10)
        for (examPaper in examsQuestionsList) {
            val questionNumberTextView = TextView(this)
            val questionText = TextView(this)
            val spanString = SpannableString(examPaper.questionNo)
            spanString.setSpan(StyleSpan(Typeface.BOLD), 0, spanString.length, 0)
            spanString.setSpan(StyleSpan(Typeface.ITALIC), 0, spanString.length, 0)
            questionNumberTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
            questionNumberTextView.textSize = 26f
            questionNumberTextView.setPadding(10, 40, 10, 10)
            questionNumberTextView.text = spanString
            questionNumberTextView.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

            questionText.setTextColor(ContextCompat.getColor(this, R.color.black))
            questionText.setTypeface(questionText.typeface, Typeface.ITALIC)
            questionText.textSize = 16f
            questionText.setPadding(10, 0, 10, 10)
            questionText.text = examPaper.questionsText
            questionText.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

            val radioGroups = createRadioButton(examPaper.questionsOptions)
            radioGroups.setPadding(20, 30, 20, 10)
            radioGroups.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            (linearLayout as LinearLayout).addView(questionNumberTextView)
            linearLayout.addView(questionText)
            linearLayout.addView(radioGroups)
        }
    }

    private fun createRadioButton(optionsList : ArrayList<String>) : RadioGroup {
        val radioButton = arrayOfNulls<RadioButton>(optionsList.size)
        val radioGroup = RadioGroup(this) //create the RadioGroup
        radioGroup.orientation = RadioGroup.VERTICAL //or RadioGroup.VERTICAL
        for (i in optionsList.indices) {
            radioButton[i] = RadioButton(this)

            radioButton[i]?.let {
                it.text = optionsList[i]
                it.setPadding(20, 5, 20, 10)
                it.textSize = 16f
                it.setTextColor(ContextCompat.getColor(this, R.color.black))
                it.setTypeface(it.typeface, Typeface.ITALIC)
                it.id = i + 100
            }
            radioGroup.addView(radioButton[i])
        }
        return radioGroup
    }
}