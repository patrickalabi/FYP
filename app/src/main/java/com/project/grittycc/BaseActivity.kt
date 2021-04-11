package com.project.grittycc

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.project.grittycc.constants.DialogUtils
import com.project.grittycc.constants.KeyboardUtils

/*Reference
https://www.youtube.com/watch?v=mf6Wq8jNkus
https://firebase.google.com/docs/firestore



 */

open class BaseActivity : AppCompatActivity() {

    val dataBase by lazy{
        FirebaseFirestore.getInstance()
    }

    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = DialogUtils.getProgressDialog(this)

    }


    fun showProgress1Dialog( show: Boolean) {

        if (dialog != null && show) {
            if (!dialog.isShowing)
                dialog.apply {
                    show()
                }
        } else if (dialog != null && !show) {
            if (dialog.isShowing)
                dialog.dismiss()
        }
    }

    fun alertDialogShow(message: String)
    {
        KeyboardUtils.hideKeyboard(this@BaseActivity)

        val alertDialog = android.app.AlertDialog.Builder(this).create();
        alertDialog.setMessage(message);
        alertDialog.setButton("OK") { dialog, _ ->
            dialog?.dismiss()
        };
        alertDialog.show()
    }

}