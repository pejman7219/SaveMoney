package com.example.savemoney.UI

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.poolamochikarkonm.RealmModel.IncomeModel
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import kotlinx.android.synthetic.main.add_cost.*
import kotlinx.android.synthetic.main.add_income.*
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog


class AddIncome : AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    var year:Int?=null
    var month:Int?=null
    var day:Int?=null
    var itemIncomeModel=ItemIncomeModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_income)


        setValue(intent.getIntExtra("id",0))

        //set on click listener
        onClick()
    }

    fun setValue(position: Int)
    {

        itemIncomeModel= DbHelper().readItemIncom(position)

        add_income_textView_Titele.text ="درآمد: " + itemIncomeModel.titel

        add_income_editText_description.hint ="شرح: "+ itemIncomeModel.description

        add_income_editText_feuilleton.text = itemIncomeModel.description


    }

    fun onClick()
    {

        add_income_editText_date.setOnClickListener {

            val persianCalendar = PersianCalendar()
            val datePickerDialog = DatePickerDialog.newInstance(
                this@AddIncome,
                persianCalendar.persianYear,
                persianCalendar.persianMonth,
                persianCalendar.persianDay
            )
            datePickerDialog.show(fragmentManager, "Datepickerdialog")

        }

        add_income_editText_time.setOnClickListener {

            val now = PersianCalendar()
            val tpd = TimePickerDialog.newInstance(
                this@AddIncome,
                now.get(PersianCalendar.HOUR_OF_DAY),
                now.get(PersianCalendar.MINUTE),
                true
            )

            tpd.show(fragmentManager, "TimePickerDialog")
        }


        add_income_imageButton_CheckBox.setOnClickListener {

            if (add_income_editText_amount.text.trim().isNotEmpty())
            {
                if (add_income_editText_description.text.trim().isNotEmpty())
                {
                    if (add_income_editText_date.text.trim().isNotEmpty())
                    {
                        if (add_income_editText_time.text.trim().isNotEmpty())
                        {
                            var incomeModel=IncomeModel()
                            incomeModel.amount=  add_income_editText_amount.text.toString().toInt()
                            incomeModel.description=add_income_editText_description.text.toString()
                            incomeModel.title=itemIncomeModel.titel
                            incomeModel.time=add_income_editText_time.text.toString()
                            incomeModel.date=add_income_editText_date.text.toString()
                            incomeModel.year=year
                            incomeModel.month=month
                            incomeModel.day=day

                            DbHelper().writeIncome(incomeModel)

                            finish()
                        }
                        else
                        {
                            add_income_editText_time.error="نمی تواند خالی باشد"
                        }
                    }
                    else
                    {
                        add_income_editText_date.error="نمی تواند خالی باشد"
                    }
                }
                else
                {
                    add_income_editText_description.error="نمی تواند خالی باشد"
                }
            }
            else
            {
                add_income_editText_amount.error="نمی تواند خالی باشد"
            }

        }


    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int)
    {
        add_income_editText_date.setText(year.toString()+"/"+(monthOfYear+1).toString()+"/"+dayOfMonth.toString())
        this.year=year
        this.month=monthOfYear+1
        this.day=dayOfMonth
    }

    override fun onTimeSet(view: RadialPickerLayout?, hourOfDay: Int, minute: Int)
    {
        add_income_editText_time.setText(hourOfDay.toString()+":"+minute.toString())
    }

}
