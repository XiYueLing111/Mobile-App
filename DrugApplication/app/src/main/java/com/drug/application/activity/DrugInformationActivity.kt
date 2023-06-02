package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drug.application.R
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.activity_drug_information.*

class DrugInformationActivity : AppCompatActivity() {
    private lateinit var request:Drug
    private var position:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_information)

        request = intent.extras?.getParcelable("data")!!
        position = intent.extras?.getInt("position",0)!!
        if (request != null){
            name_tv.text = request.name
            id_tv.text = request.id.toString()
            type_tv.text = request.type
            security_tv.text = request.security
            date_tv.text = request.expiryDate
            if (request.red == 1){
                red.isChecked = true
            }
            if (request.removed == 1){
                removed.isChecked = true
            }
        }


        right_img.setOnClickListener {
            if (red.isChecked){
                request.red = 1
            }
            if (removed.isChecked){
                request.removed = 1
            }
            val intent = Intent()
            intent.putExtra("position",position)
            intent.putExtra("data",request)
            setResult(RESULT_OK,intent)
            finish()
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