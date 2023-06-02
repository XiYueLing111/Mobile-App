package com.drug.application.activity

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.drug.application.R
import com.drug.application.adapter.CheckHistoryAdapter
import com.drug.application.bean.CheckHistory
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.activity_knox_wdractivity.*
import kotlinx.android.synthetic.main.check_history_list_item.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_item.view.name_tv

class CheckHistoryActivity : AppCompatActivity() {
    private lateinit var checkHistoryApdater: CheckHistoryAdapter
    lateinit var list: ArrayList<CheckHistory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_history)
        back_tv.setOnClickListener {
            finish()
        }
        list = ArrayList()
        var checkHistory1 = CheckHistory("Knox Wing Drugs Room","01/12")
        var checkHistory2 = CheckHistory("Knox Wing Drugs Room","01/27")
        var checkHistory3 = CheckHistory("Knox Wing Drugs Room","01/24")
        var checkHistory4 = CheckHistory("ward office Nurses Station & Day Stay Nurses Station","01/26")


        list.add(checkHistory1)
        list.add(checkHistory2)
        list.add(checkHistory3)
        list.add(checkHistory4)



        checkHistoryApdater = CheckHistoryAdapter(this, list)
        list_view.adapter = checkHistoryApdater
        list_view.setOnItemClickListener { adapterView, view, i, l ->
            val history = list[i]
            val intent = Intent(this,DrugStackerActivity::class.java)
            intent.putExtra("data",history)
            startActivityForResult(intent,1001)

        }

    }







    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}