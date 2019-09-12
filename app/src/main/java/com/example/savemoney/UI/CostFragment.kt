package com.example.savemoney.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.savemoney.Adapter.CostAdapter

import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper

/**
 * A simple [Fragment] subclass.
 */
class CostFragment : Fragment() {


    var list = ArrayList<ItemCostomModel>()
    var costAdapter:CostAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View=inflater.inflate(R.layout.cost_fragment, container, false)



        //link  widget to layout
        link(view)

        return view
    }



    private fun link(view:View)
    {
        var recyclerView=view.findViewById(R.id.cost_fragment_recyclerView) as RecyclerView
        recyclerView.layoutManager=GridLayoutManager(activity,3)
        list=DbHelper().readItemCostList()
        costAdapter= CostAdapter(list)
        recyclerView.adapter= costAdapter
    }

    public fun dataChange()
    {
        //Toast.makeText(context,"OK",Toast.LENGTH_LONG).show()

        costAdapter!!.dataChange()
    }




}
