package com.example.savemoney.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poolamochikarkonm.RealmModel.CostModel
import com.example.savemoney.R

class ReportCostAdapter (var list:ArrayList<CostModel>): RecyclerView.Adapter<ReportCostViewHolder>()
{
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportCostViewHolder
    {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.report_fragment_recyclerview_layout,parent,false)

        context = parent.context
        return ReportCostViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: ReportCostViewHolder, position: Int)
    {
        holder.title.setText(list[position].title)
        holder.description.setText(list[position].description)
        holder.amount.setText(list[position].amount.toString()+" تومان")
        holder.amount.setTextColor(Color.parseColor("#ffff4444"))
        holder.date.setText(list[position].time+" "+list[position].date)
    }
}

class ReportCostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{

        var title = itemView.findViewById<TextView>(R.id.report_fragment_recyclerview_layout_textView_title)
        var description = itemView.findViewById<TextView>(R.id.report_fragment_recyclerview_layout_textView_description)
        var amount = itemView.findViewById<TextView>(R.id.report_fragment_recyclerview_layout_textView_amount)
        var date = itemView.findViewById<TextView>(R.id.report_fragment_recyclerview_layout_textView_date)
}