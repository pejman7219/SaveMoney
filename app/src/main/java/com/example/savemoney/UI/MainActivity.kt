package com.example.savemoney.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import com.example.savemoney.R
import com.example.savemoney.RealmDb.DbHelper
import com.example.savemoney.SharedPref.SharedPref
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var costFragment= CostFragment()
    var incomeFragment= IncomeFragment()
    var reportFragment= ReportFragment()
    var fragmentManager=supportFragmentManager
    var fragmentTransaction=fragmentManager.beginTransaction()



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPref=SharedPref.getInstance(applicationContext)
        if(sharedPref.getData("user_status").equals(""))
        {
            initListItemCost()
            initListItemIncome()

            sharedPref.saveData("user_status","1")
        }


        fragmentTransaction.add(R.id.main_frameLayout_cost,costFragment,"costFragment")
        fragmentTransaction.add(R.id.main_frameLayout_income,incomeFragment,"incomeFragment")
        fragmentTransaction.add(R.id.main_frameLayout_report,reportFragment,"reportFragment")
        fragmentTransaction.commit()

        //set on click listener
        onClick()
    }

    private fun onClick()
    {

        main_tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?)
            {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?)
            {

            }

            override fun onTabSelected(p0: TabLayout.Tab?)
            {
                when(p0!!.position)
                {
                    0 ->
                        gotoCostFragment()
                    1 ->
                        gotoIncomeFragment()
                    2 ->
                        gotoReportFragment()

                }
            }

        })

    }

    private fun gotoCostFragment()
    {
        main_frameLayout_cost.visibility=View.VISIBLE
        main_frameLayout_income.visibility=View.GONE
        main_frameLayout_report.visibility=View.GONE
    }

    private fun gotoIncomeFragment()
    {

        main_frameLayout_cost.visibility=View.GONE
        main_frameLayout_income.visibility=View.VISIBLE
        main_frameLayout_report.visibility=View.GONE
    }


    private fun gotoReportFragment()
    {

        main_frameLayout_cost.visibility=View.GONE
        main_frameLayout_income.visibility=View.GONE
        main_frameLayout_report.visibility=View.VISIBLE
    }


    fun initListItemCost()
    {
        var listItemCost = ArrayList<ItemCostomModel>()

        var itemCostModel = ItemCostomModel()
        var i=0
        itemCostModel.id=i
        itemCostModel.background = "#EF4C50"
        itemCostModel.titel = "موادپروتئینی"
        itemCostModel.description = "گوشت,مرغ,ماهی,سوسیس,کالباس,و..."
        itemCostModel.image = R.drawable.mavadproteeni
        listItemCost.add(i,itemCostModel)


        var itemCostModel1 = ItemCostomModel()
        itemCostModel1.id=i++
        itemCostModel1.background = "#45C45E"
        itemCostModel1.titel = "میوه و سبزی"
        itemCostModel1.description = "انواع میوه و سبزی"
        itemCostModel1.image = R.drawable.mivevasabzi
        listItemCost.add(i,itemCostModel1)

        var itemCostModel2 = ItemCostomModel()
        itemCostModel2.id=i++
        itemCostModel2.background = "#F98D13"
        itemCostModel2.titel = "سوپری"
        itemCostModel2.description = "خرید سوپری,لبنیات,مواد غذایی,شوینده ها و لوازم مصرفی منزل"
        itemCostModel2.image = R.drawable.supery
        listItemCost.add(i,itemCostModel2)

        var itemCostModel3 = ItemCostomModel()
        itemCostModel3.id=i++
        itemCostModel3.background = "#09B389"
        itemCostModel3.titel = "مسکن"
        itemCostModel3.description = "اجاره منزل,هزینه نگهداری و تعمیرات منزل,شارژ آپارتمان"
        itemCostModel3.image = R.drawable.maskan
        listItemCost.add(i,itemCostModel3)

        var itemCostModel4 = ItemCostomModel()
        itemCostModel4.id=i++
        itemCostModel4.background = "#F47CA3"
        itemCostModel4.titel = "آرایشی بهداشتی"
        itemCostModel4.description = "لوازم آرایش,انواع کرم و ادکلن"
        itemCostModel4.image = R.drawable.kerem
        listItemCost.add(i,itemCostModel4)

        var itemCostModel5 = ItemCostomModel()
        itemCostModel5.id=i++
        itemCostModel5.background = "#953291"
        itemCostModel5.titel = "رفت و آمد"
        itemCostModel5.description = "هزینه تاکسی,سرویس,پیک,hj,f,sومترو و ..."
        itemCostModel5.image = R.drawable.rafto_amad
        listItemCost.add(i,itemCostModel5)

        var itemCostModel6 = ItemCostomModel()
        itemCostModel6.id=i++
        itemCostModel6.background = "#F78B7A"
        itemCostModel6.titel = "پوشاک"
        itemCostModel6.description = "خرید انواع پوشاک, کیف, ساعت,عینک و بدلیجات"
        itemCostModel6.image = R.drawable.poshak
        listItemCost.add(i,itemCostModel6)

        var itemCostModel7 = ItemCostomModel()
        itemCostModel7.id=i++
        itemCostModel7.background = "#26ADA9"
        itemCostModel7.titel = "قبوض"
        itemCostModel7.description = "قبوض آب, برق, گاز, تلفن"
        itemCostModel7.image = R.drawable.ghobooz
        listItemCost.add(i,itemCostModel7)

        var itemCostModel8 = ItemCostomModel()
        itemCostModel8.id=i++
        itemCostModel8.background = "#EC2F63"
        itemCostModel8.titel = "تحصیلات"
        itemCostModel8.description = "شهریه مدارس, شهریه دانشگاه, کلاسهای فوق برنامه,خرید کتاب و لوازم آموزشی و ..."
        itemCostModel8.image =R.drawable.kalej
        listItemCost.add(i,itemCostModel8)

        var itemCostModel9 = ItemCostomModel()
        itemCostModel9.id=i++
        itemCostModel9.background = "#7972C7"
        itemCostModel9.titel = "لوازم مصرفی"
        itemCostModel9.description = "سایر ابزار و لوازم منزل بجز مواد خوراکی و اموال"
        itemCostModel9.image = R.drawable.mahitabeh
        listItemCost.add(i,itemCostModel9)

        var itemCostModel10 = ItemCostomModel()
        itemCostModel10.id=i++
        itemCostModel10.background = "#E12C92"
        itemCostModel10.titel = "خودرو"
        itemCostModel10.description = "هزینه های تعمیر و نگهداری خودرو شامل روغن ,بنزین ,عوارض ,بیمه و ..."
        itemCostModel10.image = R.drawable.mashin
        listItemCost.add(i,itemCostModel10)

        var itemCostModel11 = ItemCostomModel()
        itemCostModel11.id=i++
        itemCostModel11.background = "#FEBC3C"
        itemCostModel11.titel = "درمان"
        itemCostModel11.description = "ویزیت پزشکان,دارو,هزینه های دندانپزشکی,بیمارستانی و درمانی"
        itemCostModel11.image =R.drawable.darman
        listItemCost.add(i,itemCostModel11)

        var itemCostModel12 = ItemCostomModel()
        itemCostModel12.id=i++
        itemCostModel12.background = "#F7904F"
        itemCostModel12.titel = "سفر"
        itemCostModel12.description = "بلیط,تور,بازدید از نقاط دیدنی و کلیه هزینه هایی که حین سفر انجام میشود"
        itemCostModel12.image =R.drawable.havapeyma
        listItemCost.add(i,itemCostModel12)

        var itemCostModel13 = ItemCostomModel()
        itemCostModel13.id=i++
        itemCostModel13.background = "#ADCE5D"
        itemCostModel13.titel = "رستوران"
        itemCostModel13.description = "رستوران,کافی شاپ ,فست فود و غذای آماده آشپزخانه و ..."
        itemCostModel13.image = R.drawable.restoran
        listItemCost.add(i,itemCostModel13)

        var itemCostModel14 = ItemCostomModel()
        itemCostModel14.id=i++
        itemCostModel14.background = "#8F3E9E"
        itemCostModel14.titel = "سرگرمی و ورزشی"
        itemCostModel14.description = "سینما,تئاتر,باشگاهای ورزشی,لوازم ورزشی,فیلم,بازیهای کامپیوتری و ..."
        itemCostModel14.image = R.drawable.shahrebazi
        listItemCost.add(i,itemCostModel14)

        var itemCostModel15 = ItemCostomModel()
        itemCostModel15.id=i++
        itemCostModel15.background = "#3CA27A"
        itemCostModel15.titel = "هدایا"
        itemCostModel15.description = "خرید هدایا به مناسبت های مختلف"
        itemCostModel15.image = R.drawable.hadaya
        listItemCost.add(i,itemCostModel15)

        var itemCostModel16 = ItemCostomModel()
        itemCostModel16.id=i++
        itemCostModel16.background = "#EA4640"
        itemCostModel16.titel = "پول تو جیبی"
        itemCostModel16.description = "پول توجیبی اعضای خانواده"
        itemCostModel16.image = R.drawable.kifpol
        listItemCost.add(i,itemCostModel16)

        var itemCostModel17 = ItemCostomModel()
        itemCostModel17.id=i++
        itemCostModel17.background = "#63C6B4"
        itemCostModel17.titel = "اینترنت"
        itemCostModel17.description = "آبونمان اینترنت و هزینه های اشتراک"
        itemCostModel17.image = R.drawable.ic_global
        listItemCost.add(i,itemCostModel17)

        var itemCostModel18 = ItemCostomModel()
        itemCostModel18.id=i++
        itemCostModel18.background = "#A0886F"
        itemCostModel18.titel = "تعمیر لوازم"
        itemCostModel18.description = "هزینه تعمیر و نگهداری لوازم برقی , الکترونیکی و سایر کالاهای سرمایه ای و ماندگار"
        itemCostModel18.image = R.drawable.taamir_lavazem
        listItemCost.add(i,itemCostModel18)

        var itemCostModel19 = ItemCostomModel()
        itemCostModel19.id=i++
        itemCostModel19.background = "#716BAF"
        itemCostModel19.titel = "خریداموال"
        itemCostModel19.description = "خرید خانه,خودرو,طلا و جواهرات , لوازم برقی منزل , موبایل , فرش و سایر کالاهای سرمایه ای و ماندگار"
        itemCostModel19.image = R.drawable.froosh_amval
        listItemCost.add(i,itemCostModel19)

        var itemCostModel20 = ItemCostomModel()
        itemCostModel20.id=i++
        itemCostModel20.background = "#D56646"
        itemCostModel20.titel = "اقساط پرداختی"
        itemCostModel20.description = "پرداخت اقساط وام یا خریدهای اقساطی"
        itemCostModel20.image = R.drawable.ic_credit_cards_payment
        listItemCost.add(i,itemCostModel20)

        var itemCostModel21 = ItemCostomModel()
        itemCostModel21.id=i++
        itemCostModel21.background = "#66A2AF"
        itemCostModel21.titel = "بانکی"
        itemCostModel21.description = "کلیه هزینه های بانکی اعم از کارمزد و جرایم"
        itemCostModel21.image = R.drawable.banki
        listItemCost.add(i,itemCostModel21)

        var itemCostModel22 = ItemCostomModel()
        itemCostModel22.id=i++
        itemCostModel22.background = "#3B8C4C"
        itemCostModel22.titel = "خیریه"
        itemCostModel22.description = "پرداخت به موسسات خیریه و برگزاری و مشارکت در مراسم خیریه"
        itemCostModel22.image = R.drawable.khyriye
        listItemCost.add(i,itemCostModel22)

        var itemCostModel23 = ItemCostomModel()
        itemCostModel23.id=i++
        itemCostModel23.background = "#0185B2"
        itemCostModel23.titel = "دست مزد"
        itemCostModel23.description = "دستمزد کارکنان یا کارگران روز مزد مانند کارگر منزل,باغبان و ..."
        itemCostModel23.image = R.drawable.dastmozd
        listItemCost.add(i,itemCostModel23)

        var itemCostModel24 = ItemCostomModel()
        itemCostModel24.id=i++
        itemCostModel24.background = "#774189"
        itemCostModel24.titel = "سایرهزینه ها"
        itemCostModel24.description = "شامل کلیه هزینه ها یی که در این دسته بندی ها پیش بینی نشده یا دسته بندی آن برای کاربر اهمیت ندارد"
        itemCostModel24.image = R.drawable.sayer_hazine
        listItemCost.add(i,itemCostModel24)

        var itemCostModel25 = ItemCostomModel()
        itemCostModel25.id=i++
        itemCostModel25.background = "#CF3063"
        itemCostModel25.titel = "پس انداز"
        itemCostModel25.description = ""
        itemCostModel25.image = R.drawable.pas_andaz
        listItemCost.add(i,itemCostModel25)

        var itemCostModel26 = ItemCostomModel()
        itemCostModel26.id=i++
        itemCostModel26.background = "#B67F5C"
        itemCostModel26.titel = "پذیرایی"
        itemCostModel26.description = ""
        itemCostModel26.image = R.drawable.paziraee
        R.drawable.parastar.toByte()
        listItemCost.add(i,itemCostModel26)

        for (itemCost in listItemCost)
        {

            DbHelper().writeItemCost(itemCost)
        }

        /*itemCostModel.id=i++
        itemCostModel.background = "#A649AE"
        itemCostModel.titel = "جدید"
        itemCostModel.image = R.drawable.add_category
        listItemCost.add(itemCostModel)*/
    }

    fun initListItemIncome()
    {

        var listItemincome = ArrayList<ItemIncomeModel>()


        var i:Int=0
        var itemincomeModel = ItemIncomeModel()
        itemincomeModel.id=i++
        itemincomeModel.background = "#F99282"
        itemincomeModel.titel = "برداشت"
        itemincomeModel.description = "برداشت از صندوق محل کار,دریافت مساعده و ..."
        itemincomeModel.image = R.drawable.ic_bardasht
        listItemincome.add(itemincomeModel)

        var itemincomeModel2 = ItemIncomeModel()
        itemincomeModel2.id=i++
        itemincomeModel2.background = "#2CB4B0"
        itemincomeModel2.description = ""
        itemincomeModel2.titel = "دست مزد"
        itemincomeModel2.image = R.drawable.dastmozd1
        listItemincome.add(itemincomeModel2)

        var itemincomeModel3 = ItemIncomeModel()
        itemincomeModel3.id=i++
        itemincomeModel3.description = "حقوق ماهیانه"
        itemincomeModel3.background = "#EA3D6D"
        itemincomeModel3.titel = "حقوق"
        itemincomeModel3.image = R.drawable.hoghoogh
        listItemincome.add(itemincomeModel3)

        var itemincomeModel4 = ItemIncomeModel()
        itemincomeModel4.id=i++
        itemincomeModel4.background = "#827AD5"
        itemincomeModel4.description = ""
        itemincomeModel4.titel = "اجاره مستغلات"
        itemincomeModel4.image = R.drawable.ejare_mostaghellat
        listItemincome.add(itemincomeModel4)

        var itemincomeModel5 = ItemIncomeModel()
        itemincomeModel5.id=i++
        itemincomeModel5.background = "#E12C92"
        itemincomeModel5.titel = "سودبانکی"
        itemincomeModel5.description = ""
        itemincomeModel5.image = R.drawable.soodbanki
        listItemincome.add(itemincomeModel5)

        var itemincomeModel6 = ItemIncomeModel()
        itemincomeModel6.id=i++
        itemincomeModel6.background = "#FEB62C"
        itemincomeModel6.description  = ""
        itemincomeModel6.titel = "یارانه"
        itemincomeModel6.image = R.drawable.yaraneh
        listItemincome.add(itemincomeModel6)

        var itemincomeModel7 = ItemIncomeModel()
        itemincomeModel7.id=i++
        itemincomeModel7.background = "#64C7B5"
        itemincomeModel7.description = ""
        itemincomeModel7.titel = "وام"
        itemincomeModel7.image = R.drawable.vam
        listItemincome.add(itemincomeModel7)

        var itemincomeModel8 = ItemIncomeModel()
        itemincomeModel8.id=i++
        itemincomeModel8.background = "#ADCE5D"
        itemincomeModel8.description = "درآمد حاصل از فروش خودرو,منزل,زمین,لوازم منزل و ..."
        itemincomeModel8.titel = "فروش اموال"
        itemincomeModel8.image = R.drawable.froosh_amval
        listItemincome.add(itemincomeModel8)

        var itemincomeModel9 = ItemIncomeModel()
        itemincomeModel9.id=i++
        itemincomeModel9.background = "#9D4FAC"
        itemincomeModel9.titel = "هدایا"
        itemincomeModel9.description="درآمدحاصل از هدایای دریافتی,پاداش و ..."
        itemincomeModel9.image = R.drawable.hadaya
        listItemincome.add(itemincomeModel9)

        var itemincomeModel10 = ItemIncomeModel()
        itemincomeModel10.id=i++
        itemincomeModel10.background = "#F67F34"
        itemincomeModel10.titel = "سایردرآمدها"
        itemincomeModel10.description=""
        itemincomeModel10.image = R.drawable.ic_money_bags
        listItemincome.add(itemincomeModel10)


        for (itemIncome in listItemincome) {

            DbHelper().writeItemIncome(itemIncome)

        }

        /*itemCostModel.id=i++
        itemCostModel.background = "#A649AE"
        itemCostModel.titel = "جدید"
        itemCostModel.image = R.drawable.add_category
        listItemCost.add(itemCostModel)*/
    }
}
