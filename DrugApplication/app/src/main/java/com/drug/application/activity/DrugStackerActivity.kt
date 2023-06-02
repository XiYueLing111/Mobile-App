package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drug.application.R
import com.drug.application.adapter.DrugAdapter
import com.drug.application.bean.CheckHistory
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.activity_drug_stacker.*
import kotlinx.android.synthetic.main.activity_drug_stacker.back_tv
import kotlinx.android.synthetic.main.activity_drug_stacker.list_view
import kotlinx.android.synthetic.main.activity_knox_wdractivity.*

class DrugStackerActivity : AppCompatActivity() {
    private lateinit var request: CheckHistory
    lateinit var list: ArrayList<Drug>
    private lateinit var drugAdapter:DrugAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_stacker)


        list = ArrayList()
        var drug1 = Drug("Controlled","Oxycodone","Safe",
            "Knox Wing Drugs Room",1,"01/24")
        var drug2 = Drug("Controlled","oxynorm","Safe",
            "Knox Wing Drugs Room",2,"05/26")
        var drug4 = Drug("controlled","Tramadol","Safe",
            "Knox Wing Drugs Room",3,"03/12")
        var drug5 = Drug("controlled","Codeine","Safe",
            "Knox Wing Drugs Room",4,"06/24")
        var drug6 = Drug("Simple","Panadol","Cupboard",
            "ward office Nurses Station & Day Stay Nurses Station",5,"08/12")
        var drug7 = Drug("Simple","lbuprofen","Cupboard",
            "ward office Nurses Station & Day Stay Nurses Station",6,"01/21")
        var drug8 = Drug("Simple","Gabapentin","Cupboard",
            "ward office Nurses Station & Day Stay Nurses Station",7,"01/31")
        var drug9 = Drug("Simple","Celebrex","Cupboard",
            "ward office Nurses Station & Day Stay Nurses Station",8,"01/15")
        drug1.red = 1
        drug2.red = 1
        list.add(drug1)
        list.add(drug2)


        drugAdapter = DrugAdapter(this, list)
        list_view.adapter = drugAdapter



        back_tv.setOnClickListener {
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}