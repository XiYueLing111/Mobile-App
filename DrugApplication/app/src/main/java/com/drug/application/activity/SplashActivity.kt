package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import com.drug.application.R
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var timer = Timer()
        class MyTimerTask() : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, DisclaimerActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        var timerTask = MyTimerTask()
        timer.schedule(timerTask, 2000)
    }
}