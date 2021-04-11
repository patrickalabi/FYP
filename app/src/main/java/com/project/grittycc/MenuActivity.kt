package com.project.grittycc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.grittycc.constants.LOGIN_USER
import com.project.grittycc.models.UserModel
import io.paperdb.Paper

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val loginUser : UserModel = Paper.book().read(LOGIN_USER) ?: UserModel("","","")

        findViewById<TextView>(R.id.login_user_name).text = loginUser.userFullName
        findViewById<TextView>(R.id.go_to_topic_screen).setOnClickListener {
            startActivity(Intent(this, TopicActivity::class.java))
        }

        findViewById<TextView>(R.id.go_to_exam_screen).setOnClickListener {
            startActivity(Intent(this, ExamActivity::class.java))
        }

        findViewById<TextView>(R.id.go_to_stats_screen).setOnClickListener {
            startActivity(Intent(this, StatsActivity::class.java))
        }

        findViewById<TextView>(R.id.logout_txt).setOnClickListener {
            Paper.book().write(LOGIN_USER, UserModel("","",""))

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}