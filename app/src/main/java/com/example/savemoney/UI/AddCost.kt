package com.example.savemoney.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import kotlinx.android.synthetic.main.add_cost.*
import kotlinx.android.synthetic.main.add_income.*

class AddCost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_cost)

        setValue(intent.getIntExtra("id",0))
    }

    fun setValue(position: Int)
    {

        var data = DbHelper().readItemCost(position)

        add_cost_textView_Titele.text = data.titel

        add_cost_editText_description.hint ="شرح: "+ data.description

        add_cost_editText_feuilleton.text = data.description


    }
}
