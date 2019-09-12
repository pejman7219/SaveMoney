package com.example.savemoney.UI


import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import com.example.savemoney.Dialog.SelectIconDialog
import com.example.savemoney.InterFace.SelectIconDialogItemClickListener
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import kotlinx.android.synthetic.main.add_sub_category.*
import me.priyesh.chroma.ColorSelectListener
import me.priyesh.chroma.ColorMode
import me.priyesh.chroma.ChromaDialog



class AddSubCategory :AppCompatActivity(),SelectIconDialogItemClickListener{

    var flag:String?=null
    var background:String="#F77A8D"
    var image:Int= R.drawable.havapeyma
    lateinit var selectIconDialog:SelectIconDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.savemoney.R.layout.add_sub_category)

        flag=intent.getStringExtra("flag")

        selectIconDialog = SelectIconDialog(this)

        //link widget to layout
        onClick()
    }

    fun onClick()
    {

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        add_sub_category_linearLayout.layoutParams.width=(displayMetrics.widthPixels/4)
        add_sub_category_linearLayout.layoutParams.height=(displayMetrics.widthPixels/4)

        selectIconDialog= SelectIconDialog(this)

        add_sub_category_imageButton_Close.setOnClickListener {

            finish()

        }

        add_sub_category_imageButton_CheckBox.setOnClickListener {

            if (!add_sub_category_editText_titel.text.trim().equals(""))
            {
                if (!add_sub_category_editText_description.text.trim().equals(""))
                {
                    if(flag.equals("income"))
                    {
                        var itemIncomeModel= ItemIncomeModel()
                        itemIncomeModel.background=background
                        itemIncomeModel.image=image
                        itemIncomeModel.titel=add_sub_category_editText_titel.text.toString()
                        itemIncomeModel.description=add_sub_category_editText_description.text.toString()

                        DbHelper().writeItemIncome(itemIncomeModel)

                        var gotoMain = Intent()
                        setResult(Activity.RESULT_OK,gotoMain)
                        finish()

                    }
                    else
                    {

                        var itemCostModel=ItemCostomModel()
                        itemCostModel.background=background
                        itemCostModel.image=image
                        itemCostModel.titel=add_sub_category_editText_titel.text.toString()
                        itemCostModel.description=add_sub_category_editText_description.text.toString()

                        DbHelper().writeItemCost(itemCostModel)

                        var gotoMain = Intent()
                        setResult(Activity.RESULT_OK,gotoMain)
                        finish()
                    }
                }
                else
                {
                    add_sub_category_editText_description.error="شرح نمی تواند خالی باشد"
                }
            }
            else
            {
                add_sub_category_editText_titel.error="عنوان نمی تواند خالی باشد"
            }

        }

        add_sub_category_editText_selectColor.setOnClickListener {

            showColorPickerDialog()
        }

        add_sub_category_editText_selectImage.setOnClickListener {

            selectIconDialog.dialog!!.show()

        }


    }

    private fun showColorPickerDialog()
    {
        ChromaDialog.Builder()
            .initialColor(Color.GREEN)
            .colorMode(ColorMode.RGB)
            .onColorSelected(object : ColorSelectListener {
                override fun onColorSelected(color: Int)
                {
                    updateTextView(color)
                }
            })
            .create()
            .show(supportFragmentManager, "dialog")
    }

    private fun updateTextView(color: Int)
    {
        add_sub_category_editText_selectColor.setText(String.format("#%06X", 0xFFFFFF and color))
        add_sub_category_cardView.setCardBackgroundColor(color)
        background=String.format("#%06X", 0xFFFFFF and color)
    }

    override fun onClick(imageId: Int) {

        selectIconDialog.dialog!!.dismiss()
        add_sub_category_imageView_image.setImageResource(imageId)
        image=imageId


    }
}