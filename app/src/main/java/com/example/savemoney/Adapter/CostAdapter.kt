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
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import com.example.savemoney.UI.AddCost
import com.example.savemoney.UI.AddSubCategory


class CostAdapter(var list:ArrayList<ItemCostomModel>): RecyclerView.Adapter<CostAdapter.CostsViewHolder>()
{


    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostsViewHolder
    {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_ci_layout,parent,false)

        context = parent.context
        return CostsViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size+1
    }

    fun dataChange()
    {
        list.clear()
        list= DbHelper().readItemCostList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CostsViewHolder, position: Int)
    {

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)

        holder.layout.layoutParams.width=(displayMetrics.widthPixels/3)
        holder.layout.layoutParams.height=(displayMetrics.widthPixels/3)

        if(position==list.size)
        {
            holder.itemView.setOnClickListener {

                var gotoAddSubCategory = Intent(context, AddSubCategory::class.java)
                gotoAddSubCategory.putExtra("flag","cost")
                (context as Activity).startActivityForResult(gotoAddSubCategory,4545)

            }

            holder.cardView.setCardBackgroundColor(Color.parseColor("#A649AD"))
            holder.image.setImageResource(R.drawable.add_category)
            holder.name.text="جدید"
        }
        else
        {
            holder.itemView.setOnClickListener {

                var gotoActivityIncome = Intent(context, AddCost::class.java)
                gotoActivityIncome.putExtra("id",position+1)
                ((context)).startActivity(gotoActivityIncome)


            }

            holder.cardView.setCardBackgroundColor(Color.parseColor(list[position].background))
            holder.image.setImageResource(list[position].image!!)
            holder.name.setText(list[position].titel)
        }

    }



    class CostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var cardView=itemView.findViewById<CardView>(R.id.recyclerview_ci_layout_cardView)
        var layout=itemView.findViewById<LinearLayout>(R.id.recyclerview_ci_layout_linearLayout)
        var image =itemView.findViewById<ImageView>(R.id.recyclerview_ci_layout_imageView_image)
        var name = itemView.findViewById<TextView>(R.id.recyclerview_ci_layout_textView_name)
    }
}