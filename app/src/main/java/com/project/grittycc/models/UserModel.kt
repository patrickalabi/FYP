package com.project.grittycc.models

data class UserModel(val userFullName : String, val userEmailAddress: String, val userPassword: String, var rememberMe: Boolean = false)