package com.project.grittycc.constants

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.project.grittycc.R


class DialogUtils {
    companion object {
        fun getProgressDialog(context: Context): AlertDialog {
            val dialogBuilder = AlertDialog.Builder(context)
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val dialogView = inflater.inflate(R.layout.progress_layout, null)
            dialogBuilder.setView(dialogView)


            val alertDialog = dialogBuilder.create()
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alertDialog.setCancelable(false)
            //alertDialog.show();

            return alertDialog
        }
    }
}