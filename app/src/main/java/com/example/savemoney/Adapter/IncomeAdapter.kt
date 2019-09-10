package com.example.savemoney.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import com.example.savemoney.R
import com.example.savemoney.UI.AddIncome

class IncomeAdapter (var list:ArrayList<ItemIncomeModel>): RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>()
{

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder
    {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_ci_layout,parent,false)
        context = parent.context
        return IncomeViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int)
    {

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)

        holder.layout.layoutParams.width=(displayMetrics.widthPixels/3)
        holder.layout.layoutParams.height=(displayMetrics.widthPixels/3)

        if(position==list.size)
        {
            holder.itemView.setOnClickListener {


            }

            holder.cardView.setCardBackgroundColor(Color.parseColor("#A649AD"))
            holder.image.setImageResource(R.drawable.add_category)
            holder.name.setText("جدید")
        }
        else
        {
            holder.itemView.setOnClickListener {

                var gotoActivityIncome = Intent(context,AddIncome::class.java)
                gotoActivityIncome.putExtra("id",position+1)
                ((context)).startActivity(gotoActivityIncome)


            }

            holder.cardView.setCardBackgroundColor(Color.parseColor(list[position].background))
            holder.image.setImageResource(list[position].image!!)
            holder.name.setText(list[position].titel)
        }

    }
    class IncomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var cardView=itemView.findViewById<CardView>(R.id.recyclerview_ci_layout_cardView)
        var layout=itemView.findViewById<LinearLayout>(R.id.recyclerview_ci_layout_linearLayout)
        var image =itemView.findViewById<ImageView>(R.id.recyclerview_ci_layout_imageView_image)
        var name = itemView.findViewById<TextView>(R.id.recyclerview_ci_layout_textView_name)
    }
}