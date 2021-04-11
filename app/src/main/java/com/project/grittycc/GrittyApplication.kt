package com.project.grittycc

import android.app.Application
import com.google.firebase.FirebaseApp
import io.paperdb.Paper

class GrittyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
        FirebaseApp.initializeApp(this)

    }
}