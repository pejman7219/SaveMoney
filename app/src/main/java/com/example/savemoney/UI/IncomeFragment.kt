package com.example.savemoney.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import com.example.savemoney.Adapter.IncomeAdapter

import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper

/**
 * A simple [Fragment] subclass.
 */
class IncomeFragment : Fragment() {


    var list = ArrayList<ItemIncomeModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.income_fragment, container, false)


        //link  widget to layout
        link(view)

        return view
    }




    private fun link(view: View)
    {
        var recyclerView = view.findViewById(R.id.income_fragment_recyclerView) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        list=DbHelper().readItemIncomList()
        recyclerView.adapter = IncomeAdapter(list)
    }
}

