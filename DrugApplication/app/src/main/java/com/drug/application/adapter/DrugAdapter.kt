package com.drug.application.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.drug.application.R
import com.drug.application.bean.Drug
import kotlinx.android.synthetic.main.list_item.view.*

class DrugAdapter(val context: Context, val numList: ArrayList<Drug>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val itemView = convertView ?: li.inflate(R.layout.list_item, parent, false)
        var drug = numList[position]
        itemView.name_tv.text = drug.name
        if (drug.red == 1)
            itemView.mark_img.visibility = View.VISIBLE
        if (drug.red == 0)
            itemView.mark_img.visibility = View.GONE
        if (drug.removed == 1)
            itemView.name_tv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
        if (drug.removed == 0){
            itemView.name_tv.paint.flags = 0
            itemView.name_tv.invalidate()
        }
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