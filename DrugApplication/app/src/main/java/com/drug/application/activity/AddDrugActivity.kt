package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drug.application.R
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.activity_add_drug.*

class AddDrugActivity : AppCompatActivity() {
    private var id:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_drug)

        id = intent.extras?.getInt("id",0)!!

        back_tv.setOnClickListener {
            finish()

        }

        add_tv.setOnClickListener {
            val drugName = drug_name_edit.text.toString()
            val drugType = drug_type_edit.text.toString()
            val security = security_edit.text.toString()
            val storageLocation = storage_location_edit.text.toString()
            if (drugName.isNotEmpty() && drugType.isNotEmpty() && security.isNotEmpty() &&
                storageLocation.isNotEmpty()){
                var drug = Drug(
                    drugType,drugName,security,
                    storageLocation,id+1,"01/15")
                val intent = Intent()
                intent.putExtra("data",drug)
                setResult(RESULT_OK,intent)
                finish()
            }


        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}