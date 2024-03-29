package com.example.bai11_gridview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridView (val activity: Activity, val list:List<OutData>) : ArrayAdapter<OutData>(activity,R.layout.layout_item) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexts = activity.layoutInflater
        val rowView = contexts.inflate(R.layout.layout_item,parent,false)

        val images = rowView.findViewById<ImageView>(R.id.imgPhim)
        val txtPhim = rowView.findViewById<TextView>(R.id.txtTenPhim)

        images.setImageResource(list[position].images)
        txtPhim.text = list[position].tenphim
        return rowView
    }
}