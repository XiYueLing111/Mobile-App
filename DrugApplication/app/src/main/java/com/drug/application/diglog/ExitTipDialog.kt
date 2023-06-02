package com.drug.application.diglog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.drug.application.R
import kotlinx.android.synthetic.main.dialog_sign_date.*

class ExitTipDialog :Dialog{
    constructor(context: Context) : this(context,0)

    constructor(context: Context, themeResId: Int) : super(context, R.style.dialog){
        setContentView(R.layout.dialog_exit_tip)
        window?.setGravity(Gravity.CENTER)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    fun setOnclickListener(listener: View.OnClickListener){
        if (positivebtexit !== null){
            positivebtexit.setOnClickListener(listener)
        }
        if (negetiveimgexit !== null){
            negetiveimgexit.setOnClickListener(listener)
        }

    }

}