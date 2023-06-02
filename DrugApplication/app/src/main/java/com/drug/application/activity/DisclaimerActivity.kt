package com.drug.application.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.drug.application.R
import java.util.*

class DisclaimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disclaimer)
        val layout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        layout.setOnClickListener {
            startActivity(Intent(this@DisclaimerActivity, LoginActivity::class.java))
            finish()
        }

    }
}


