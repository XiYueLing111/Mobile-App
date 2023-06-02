package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.drug.application.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.username_edit

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        create_tv.setOnClickListener {
            val firstname = first_name_edit.text
            val lastname = last_name_edit.text
            val number = number_edit.text
            val pin = pin_edit.text
            val user = username_edit.text

            if (firstname.isEmpty() || lastname.isEmpty()|| number.isEmpty()|| pin.isEmpty()|| user.isEmpty()){
                Toast.makeText(this,"Please enter complete", Toast.LENGTH_SHORT).show()
            }else{
                finish()
            }
        }

        back_tv.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}