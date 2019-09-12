package com.example.savemoney.Dialog

import android.app.Activity
import android.util.DisplayMetrics
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.savemoney.InitList.ListOfIcon
import com.example.savemoney.InterFace.SelectIconDialogItemClickListener


class SelectIconDialog(context: Context) {

    var dialog:Dialog? = null
    var recycler:RecyclerView? = null
    var listIcon=ListOfIcon().list()
    var adapter=selectIconDialogAdapter(listIcon,context)
    private var mainLayout:LinearLayout? =null



    init {

        // define Dialog
        dialog = Dialog(context,com.example.savemoney.R.style.PauseDialog)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(com.example.savemoney.R.layout.select_icon_dialog_layout)
        dialog!!.window!!.setBackgroundDrawableResource(com.example.savemoney.R.drawable.dialog_background_border)

        //define widget Dialog
        mainLayout = dialog!!.findViewById(com.example.savemoney.R.id.select_icon_dialog_layout_mainLayout)
        recycler=dialog!!.findViewById(com.example.savemoney.R.id.select_icon_dialog_layout_recyclerView)
        recycler!!.layoutManager=GridLayoutManager(context,3)
        recycler!!.adapter=adapter


        //set size
        val displaymetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
        mainLayout!!.layoutParams.width = displaymetrics.widthPixels - 40
        mainLayout!!.layoutParams.height = displaymetrics.heightPixels - 60
    }

    class selectIconDialogAdapter(var listIcon:ArrayList<Int>,var context: Context):RecyclerView.Adapter<selectIconDialogAdapter.selectIconDialogViewHolder>()
    {

        var pos: Int?=null
        var select:SelectIconDialogItemClickListener?=null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): selectIconDialogViewHolder {


            var view=LayoutInflater.from(parent.context).inflate(com.example.savemoney.R.layout.select_icon_dialog_recyclerview_layout,parent,false)

            return selectIconDialogViewHolder(view)
        }

        override fun getItemCount(): Int
        {
            return listIcon.size
        }

        override fun onBindViewHolder(holder: selectIconDialogViewHolder, position: Int)
        {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)

            holder.layout.layoutParams.width=(displayMetrics.widthPixels/4)
            holder.layout.layoutParams.height=(displayMetrics.widthPixels/4)

            holder.image.setImageResource(listIcon[position])



            holder.itemView.setOnClickListener {

             var selectIconDialogItemClickListener=(context as Activity) as SelectIconDialogItemClickListener
                selectIconDialogItemClickListener.onClick(listIcon[position])

            }

        }

        class selectIconDialogViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
        {

            var image = itemview.findViewById<ImageView>(com.example.savemoney.R.id.select_icon_dialog_recyclerview_layout_imageView_image)

            var layout = itemview.findViewById<LinearLayout>(com.example.savemoney.R.id.select_icon_dialog_recyclerview_layout_linearLayout)

        }
    }

}