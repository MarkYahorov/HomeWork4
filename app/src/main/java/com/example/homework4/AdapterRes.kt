package com.example.homework4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRes(var context: Context?, private val colorsArrayList: ArrayList<ColorsPuncts>)
    : RecyclerView.Adapter<AdapterRes.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var item = itemView.findViewById<View>(R.id.rec_item)
        private var textColor = itemView.findViewById<TextView>(R.id.textView)

        fun bind(listItem:ColorsPuncts){
            item.setBackgroundColor(listItem.color)
            textColor.text = listItem.hex_code
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(
            R.layout.recycler_item,
            parent,
            false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = colorsArrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var colorBG: ColorsPuncts = colorsArrayList[position]
        holder.bind(colorBG)
    }



}