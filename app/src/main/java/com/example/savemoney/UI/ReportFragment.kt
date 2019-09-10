package com.example.savemoney.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.savemoney.R


class ReportFragment : Fragment() {

    var textView:TextView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =inflater.inflate(R.layout.report_fragment, container, false)

        //link widget to layout
        link(view)

        return view
    }

    private fun link(view: View)
    {
        //TextView
        textView=view.findViewById<TextView>(R.id.report_fragment_textView)
    }



}
