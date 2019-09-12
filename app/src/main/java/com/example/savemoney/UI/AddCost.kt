package com.example.savemoney.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.poolamochikarkonm.RealmModel.CostModel
import com.example.poolamochikarkonm.RealmModel.IncomeModel
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import kotlinx.android.synthetic.main.add_cost.*
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.add_income.*


class AddCost : AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    var year:Int?=null
    var month:Int?=null
    var day:Int?=null
    var itemCostomModel=ItemCostomModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_cost)

        setValue(intent.getIntExtra("id",0))

        //set on click listener
        onClick()
    }

    fun setValue(position: Int)
    {

        itemCostomModel= DbHelper().readItemCost(position)

        add_cost_textView_Titele.text ="هزینه: " + itemCostomModel.titel

        add_cost_editText_description.hint ="شرح: "+ itemCostomModel.description

        add_cost_editText_feuilleton.text = itemCostomModel.description


    }

    fun onClick()
    {

        add_cost_editText_date.setOnClickListener {

            val persianCalendar = PersianCalendar()
            val datePickerDialog = DatePickerDialog.newInstance(
                this@AddCost,
                persianCalendar.persianYear,
                persianCalendar.persianMonth,
                persianCalendar.persianDay
            )
            datePickerDialog.show(fragmentManager, "Datepickerdialog")

        }

        add_cost_editText_time.setOnClickListener {

            val now = PersianCalendar()
            val tpd = TimePickerDialog.newInstance(
                this@AddCost,
                now.get(PersianCalendar.HOUR_OF_DAY),
                now.get(PersianCalendar.MINUTE),
                true
            )

            tpd.show(fragmentManager, "TimePickerDialog")

        }

        add_cost_imageButton_CheckBox.setOnClickListener {

            if (add_cost_editText_amount.text.trim().isNotEmpty())
            {
                if (add_cost_editText_description.text.trim().isNotEmpty())
                {
                    if (add_cost_editText_date.text.trim().isNotEmpty())
                    {
                        if (add_cost_editText_time.text.trim().isNotEmpty())
                        {
                            var costModel= CostModel()
                            costModel.amount=  add_cost_editText_amount.text.toString().toInt()
                            costModel.description=add_cost_editText_description.text.toString()
                            costModel.title=itemCostomModel.titel
                            costModel.time=add_cost_editText_time.text.toString()
                            costModel.date=add_cost_editText_date.text.toString()
                            costModel.year=year
                            costModel.month=month
                            costModel.day=day

                            DbHelper().writeCost(costModel)

                            finish()
                        }
                        else
                        {
                            add_cost_editText_time.error="نمی تواند خالی باشد"
                        }
                    }
                    else
                    {
                        add_cost_editText_date.error="نمی تواند خالی باشد"
                    }
                }
                else
                {
                    add_cost_editText_description.error="نمی تواند خالی باشد"
                }
            }
            else
            {
                add_cost_editText_amount.error="نمی تواند خالی باشد"
            }

        }


        add_cost_imageButton_Close.setOnClickListener { finish() }

    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int)
    {
        add_cost_editText_date.setText(year.toString()+"/"+(monthOfYear+1).toString()+"/"+dayOfMonth.toString())
        this.year=year
        this.month=monthOfYear+1
        this.day=dayOfMonth
    }

    override fun onTimeSet(view: RadialPickerLayout?, hourOfDay: Int, minute: Int)
    {
        add_cost_editText_time.setText(hourOfDay.toString()+":"+minute.toString())
    }

}
