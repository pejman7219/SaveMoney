package com.example.savemoney.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poolamochikarkonm.RealmModel.CostModel
import com.example.poolamochikarkonm.RealmModel.IncomeModel
import com.example.savemoney.Adapter.ReportCostAdapter
import com.example.savemoney.Adapter.ReportIncomeAdapter
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar


class ReportFragment : Fragment() {

    var income:TextView?=null
    var cost :TextView?=null
    var listCostModel=ArrayList<CostModel>()
    var listIncomeModel=ArrayList<IncomeModel>()
    var recyclerView:RecyclerView?=null
    var costAdapter:ReportCostAdapter?=null
    var incomeAdapter:ReportIncomeAdapter?=null
    val persianCalendar = PersianCalendar()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =inflater.inflate(R.layout.report_fragment, container, false)

        //link widget to layout
        link(view)

        return view
    }

    private fun link(view: View)
    {


        //TextView
        income=view.findViewById(R.id.report_fragment_textView_income) as TextView
        cost=view.findViewById(R.id.report_fragment_textView_cost) as TextView

        //RecyclerView
        recyclerView=view.findViewById(R.id.report_fragment_recyclerView) as RecyclerView
        recyclerView!!.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        

        //set on click listener
        onClick()


    }

    fun onClick()
    {
        income?.setOnClickListener {

            listIncomeModel.clear()
            listIncomeModel=DbHelper().readIncomList(persianCalendar.persianYear,persianCalendar.persianMonth+1)
            incomeAdapter= ReportIncomeAdapter(listIncomeModel)
            recyclerView!!.adapter=incomeAdapter

        }

        cost?.setOnClickListener {

            listCostModel.clear()
            listCostModel=DbHelper().readCostList(persianCalendar.persianYear,persianCalendar.persianMonth+1)
            costAdapter= ReportCostAdapter(listCostModel)
            recyclerView!!.adapter=costAdapter
        }
    }

    public fun SetData()
    {
        listCostModel.clear()
        listCostModel=DbHelper().readCostList(persianCalendar.persianYear,persianCalendar.persianMonth+1)
        costAdapter= ReportCostAdapter(listCostModel)
        recyclerView!!.adapter=costAdapter
    }



}
