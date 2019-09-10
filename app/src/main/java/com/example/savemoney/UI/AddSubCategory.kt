package com.example.savemoney.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_sub_category.*

class AddSubCategory :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(com.example.savemoney.R.layout.add_sub_category)

        //link widget to layout
        onClick()
    }

    fun onClick()
    {
        add_sub_category_imageButton_Close.setOnClickListener {

            finish()

        }

        add_sub_category_imageButton_CheckBox.setOnClickListener {

            
        }
    }
}