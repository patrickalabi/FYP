package com.project.grittycc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.project.grittycc.constants.LOGIN_USER
import com.project.grittycc.constants.USER_LISTING
import com.project.grittycc.constants.showToast
import com.project.grittycc.models.UserModel
import io.paperdb.Paper

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.go_to_sign_up).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.login_btn).setOnClickListener {
            val emailAddress = findViewById<EditText>(R.id.user_email_address)
            val password = findViewById<EditText>(R.id.password_text)
            showProgress1Dialog(true)
            if (emailAddress.text.toString() == "") {
                emailAddress.error = "Please enter valid email address"
                return@setOnClickListener
            }

            if (password.text.toString().length < 6) {
                password.error = "Please enter password minimum 6 characters"
                return@setOnClickListener
            }

            dataBase.collection("Users").whereEqualTo("Email", emailAddress.text.toString()).get()
                .addOnCompleteListener { user ->
                    showProgress1Dialog(false)

                    if (user.isSuccessful) {
                        showProgress1Dialog(false)
                        var isFlag = false
                        var loginUser: UserModel? = null
                        user.result?.documents?.let { data ->
                            for (i in data) {
                                i.get("Password")?.let { pass ->
                                    if (pass.toString() == password.text.toString()) {
                                        isFlag = true
                                        loginUser = UserModel(
                                            i.get("Username").toString(),
                                            i.get("Email").toString(),
                                            i.get("Password").toString(),
                                            findViewById<CheckBox>(R.id.check_remember).isChecked
                                        )
                                    }
                                }
                            }

                            if (isFlag){
                                //for saving user in session
                                Paper.book().write(LOGIN_USER, loginUser)
                                startActivity(Intent(this, MenuActivity::class.java))
                                finish()
                            }else{
                                alertDialogShow("Please check your email and password its not correct")
                            }
                        }

                    } else {
                        showProgress1Dialog(false)
                        alertDialogShow("Please check internet or your email please")
                        return@addOnCompleteListener
                    }
                }

        }
    }
}