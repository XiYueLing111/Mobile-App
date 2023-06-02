package com.drug.application.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.drug.application.R
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_edit_profile.back_tv
import kotlinx.android.synthetic.main.activity_edit_profile.first_name_edit
import kotlinx.android.synthetic.main.activity_edit_profile.last_name_edit
import kotlinx.android.synthetic.main.activity_edit_profile.number_edit
import kotlinx.android.synthetic.main.activity_edit_profile.pin_edit
import kotlinx.android.synthetic.main.activity_edit_profile.username_edit
import kotlinx.android.synthetic.main.activity_register.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        back_tv.setOnClickListener {
            finish()
        }

        changes_tv.setOnClickListener {
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


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}