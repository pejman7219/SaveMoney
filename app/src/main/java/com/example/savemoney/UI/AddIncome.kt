package com.example.savemoney.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import kotlinx.android.synthetic.main.add_income.*

class AddIncome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_income)


        setValue(intent.getIntExtra("id",0))
    }

    fun setValue(position: Int)
    {

        var data = DbHelper().readItemIncom(position)

        add_income_textView_Titele.text = data.titel

        add_income_editText_description.hint ="شرح: "+ data.description

        add_income_editText_feuilleton.text = data.description


    }
}
