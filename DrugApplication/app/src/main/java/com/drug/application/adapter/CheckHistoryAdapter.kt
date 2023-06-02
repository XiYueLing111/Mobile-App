package com.drug.application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.drug.application.R
import com.drug.application.bean.CheckHistory
import kotlinx.android.synthetic.main.check_history_list_item.view.*

class CheckHistoryAdapter(val context: Context, val numList: ArrayList<CheckHistory>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val itemView = convertView ?: li.inflate(R.layout.check_history_list_item, parent, false)
        var checkHistory = numList[position]
        itemView.name_tv.text = checkHistory.storageLocation
        itemView.mark_tv.text = checkHistory.date

        return itemView
    }


    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return numList.size
    }

}