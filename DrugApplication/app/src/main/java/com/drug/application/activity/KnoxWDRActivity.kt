package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.drug.application.R
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.activity_knox_wdractivity.*
import com.drug.application.adapter.DrugAdapter
import com.drug.application.diglog.ExitTipDialog
import com.drug.application.diglog.SignDateDiaolog
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.dialog_sign_date.*


class KnoxWDRActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Drug>
    private lateinit var drugAdapter:DrugAdapter
    private val edialog: SignDateDiaolog by lazy {
        SignDateDiaolog(this)
    }

    private val exitTipDialog: ExitTipDialog by lazy {
        ExitTipDialog(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knox_wdractivity)

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
        list.add(drug1)
        list.add(drug2)
        list.add(drug4)
        list.add(drug5)
        list.add(drug6)
        list.add(drug7)
        list.add(drug8)
        list.add(drug9)


        drugAdapter = DrugAdapter(this, list)
        list_view.adapter = drugAdapter
        list_view.setOnItemClickListener { adapterView, view, i, l ->
            val drug = list[i]
            val intent = Intent(this,DrugInformationActivity::class.java)
            intent.putExtra("data",drug)
            startActivityForResult(intent,1001)


        }
        add_drug_tv.setOnClickListener {
            val intent = Intent(this,AddDrugActivity::class.java)
            var i = 0
            for (d in list){
                if (d.id > i)
                    i = d.id
            }
            intent.putExtra("id",i)
            startActivityForResult(intent,1000)

        }


        complete_tv.setOnClickListener {
            showSignDate()

        }

        back_tv.setOnClickListener {
            showExit()
        }

    }


    fun showSignDate(){
        edialog.show()
        edialog.setOnclickListener(object :View.OnClickListener{
            override fun onClick(v: View) {
                
                if(v.id == R.id.negetiveimgexit){
                    edialog.dismiss()
                }
                if (v.id == R.id.positivebtexit){
                    finish()
                }
            }
        })
    }


    fun showExit(){
        exitTipDialog.show()
        exitTipDialog.setOnclickListener(object :View.OnClickListener{
            override fun onClick(v: View) {
                if(v.id == R.id.negetiveimgexit){
                    exitTipDialog.dismiss()
                }
                if (v.id == R.id.positivebtexit){
                    finish()
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        if (edialog.isShowing){
            exitTipDialog.dismiss()
        }

        if (exitTipDialog.isShowing){
            exitTipDialog.dismiss()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK && data != null){
            var position = data.getIntExtra("position",0)
            val drug:Drug = data.getParcelableExtra("data")
            list.set(position,drug)
            drugAdapter.notifyDataSetChanged()
        }
        if (requestCode == 1000 && resultCode == RESULT_OK && data != null){
            val drug:Drug = data.getParcelableExtra("data")
            list.add(drug)
            drugAdapter.notifyDataSetChanged()
        }
    }




    override fun onBackPressed() {
        super.onBackPressed()
        showExit()
    }


}