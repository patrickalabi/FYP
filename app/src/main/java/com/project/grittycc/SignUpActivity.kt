package com.project.grittycc

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import com.project.grittycc.constants.showToast
import java.util.*

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<LinearLayout>(R.id.sign_up_user).setOnClickListener {
            val userFullName = findViewById<EditText>(R.id.userName)
            val emailAddress = findViewById<EditText>(R.id.user_email_address)
            val password = findViewById<EditText>(R.id.password_text)
            if (userFullName.text.toString() == "") {
                userFullName.error = "Please enter your name"
                return@setOnClickListener
            }

            if (emailAddress.text.toString() == "") {
                emailAddress.error = "Please enter valid email address"
                return@setOnClickListener
            }

            if (password.text.toString().length < 8) {
                password.error = "Please enter password minimum 8 characters"
                return@setOnClickListener
            }

            showProgress1Dialog(true)

            val user = hashMapOf(
                "Email" to emailAddress.text.toString(),
                "Password" to password.text.toString(),
                "Username" to userFullName.text.toString()
            )

            dataBase.collection("Users").whereEqualTo("Email", emailAddress.text.toString()).get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        it.result?.documents?.let { data ->
                            if (data.isEmpty()) {
                                dataBase.collection("Users").add(user)
                                    .addOnCompleteListener { login ->
                                        if (login.isSuccessful) {
                                            showProgress1Dialog(false)
                                            showToast(this, "User created successfully")
                                            finish()
                                        } else {
                                            showProgress1Dialog(false)
                                            login.exception?.message?.let { it1 ->
                                                showToast(
                                                    this,
                                                    it1
                                                )
                                            }

                                        }
                                    }
                            } else {
                                showProgress1Dialog(false)
                                alertDialogShow("This email is already being used!")
                            }
                        }

                    } else {
                        showProgress1Dialog(false)
                        it.exception?.message?.let { it1 -> showToast(this, it1) }
                    }
                }

        }
    }


}