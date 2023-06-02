package com.drug.application.activity

import android.content.Intent
import kotlinx.android.synthetic.main.activity_login.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.drug.application.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_tv.setOnClickListener {
            val user = username_edit.text
            val pwd = passwrod_edit.text
            if (user.isEmpty() || pwd.isEmpty()){
                Toast.makeText(this,"Please enter complete",Toast.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        }
        register_tv.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }


    }
}