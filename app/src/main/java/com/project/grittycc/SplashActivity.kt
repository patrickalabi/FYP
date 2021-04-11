package com.project.grittycc

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.project.grittycc.constants.LOGIN_USER
import com.project.grittycc.constants.USER_LISTING
import com.project.grittycc.models.UserModel
import io.paperdb.Paper


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val loginUser : UserModel = Paper.book().read(LOGIN_USER) ?: UserModel("","","")
            if (loginUser.rememberMe.not()){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            }

        }, 5000)

    }
}