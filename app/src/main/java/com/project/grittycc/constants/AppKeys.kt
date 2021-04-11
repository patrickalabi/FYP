package com.project.grittycc.constants

import android.content.Context
import android.widget.Toast

val USER_LISTING = "com.project.grittycc.constants.users_listing"
val LOGIN_USER = "com.project.grittycc.constants.login_user"

/*
    Code for Toast
    https://stackoverflow.com/questions/36826004/how-do-you-display-a-toast-using-kotlin-on-android
 */
fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}