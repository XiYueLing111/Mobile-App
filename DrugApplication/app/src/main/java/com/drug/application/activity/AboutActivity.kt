package com.drug.application.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drug.application.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        back_tv.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}