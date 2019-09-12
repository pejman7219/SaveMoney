package com.example.savemoney.RealmDb

import android.content.Context
import android.util.Log
import com.example.poolamochikarkonm.RealmModel.CostModel
import com.example.poolamochikarkonm.RealmModel.IncomeModel
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import io.realm.Realm
import io.realm.Sort

class DbHelper {
    lateinit var context: Context
    var realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }


    fun writeItemIncome(obj: ItemIncomeModel) {

        realm.executeTransaction { realm ->
            var number = realm.where(ItemIncomeModel::class.java).max("id")
            val nextid: Int

            if (number == null) {
                nextid = 1
            } else {
                nextid = number.toInt() + 1
            }


            val objItemIncomeModel = realm.createObject(ItemIncomeModel::class.java, nextid)
            objItemIncomeModel.background = obj.background
            objItemIncomeModel.description = obj.description
            objItemIncomeModel.image = obj.image
            objItemIncomeModel.titel = obj.titel
            Log.i("writeincom", objItemIncomeModel.toString())
        }
    }

    fun writeItemCost(obj: ItemCostomModel) {

        realm.executeTransaction { realm ->
            var number = realm.where(ItemCostomModel::class.java).max("id")
            val nextid: Int

            if (number == null) {
                nextid = 1
            } else {
                nextid = number.toInt() + 1
            }


            val objItemIncomeModel = realm.createObject(ItemCostomModel::class.java, nextid)
            objItemIncomeModel.background = obj.background
            objItemIncomeModel.description = obj.description
            objItemIncomeModel.image = obj.image
            objItemIncomeModel.titel = obj.titel
            Log.i("f", objItemIncomeModel.toString())
        }
    }

    fun readItemIncomList(): ArrayList<ItemIncomeModel> {
        var Item = ArrayList<ItemIncomeModel>()
        var result = realm.where(ItemIncomeModel::class.java).findAll()
        for (c in result)
            Item.add(c)
        return Item
    }


    fun readItemIncom(id: Int): ItemIncomeModel {
        var Item = ItemIncomeModel()
        var result = realm.where(ItemIncomeModel::class.java).equalTo("id", id).findFirst()

        if (result != null) {
            Item = result

        }

        return Item

    }


    fun readItemCostList(): ArrayList<ItemCostomModel> {
        var Item = ArrayList<ItemCostomModel>()
        var result = realm.where(ItemCostomModel::class.java).findAll()
        for (c in result)
            Item.add(c)
        return Item
    }


    fun readItemCost(id: Int): ItemCostomModel {
        var Item = ItemCostomModel()
        var result = realm.where(ItemCostomModel::class.java).equalTo("id", id).findFirst()

        if (result != null) {
            Item = result

        }

        return Item

    }

    fun writeIncome(obj: IncomeModel) {

        realm.executeTransaction { realm ->
            var number = realm.where(IncomeModel::class.java).max("id")
            val nextid: Int

            if (number == null) {
                nextid = 1
            } else {
                nextid = number.toInt() + 1
            }


            val objIncomeModel = realm.createObject(IncomeModel::class.java, nextid)
            objIncomeModel.amount=obj.amount
            objIncomeModel.description=obj.description
            objIncomeModel.title=obj.title
            objIncomeModel.time=obj.time
            objIncomeModel.year=obj.year
            objIncomeModel.month=obj.month
            objIncomeModel.day=obj.day
            objIncomeModel.date=obj.date

        }
    }

    fun writeCost(obj: CostModel) {

        realm.executeTransaction { realm ->
            var number = realm.where(CostModel::class.java).max("id")
            val nextid: Int

            if (number == null) {
                nextid = 1
            } else {
                nextid = number.toInt() + 1
            }


            val objCostModel = realm.createObject(CostModel::class.java, nextid)
            objCostModel.amount=obj.amount
            objCostModel.description=obj.description
            objCostModel.title=obj.title
            objCostModel.time=obj.time
            objCostModel.year=obj.year
            objCostModel.month=obj.month
            objCostModel.day=obj.day
            objCostModel.date=obj.date
        }
    }

    fun readIncomList(year:Int,month:Int): ArrayList<IncomeModel>
    {
        var list = ArrayList<IncomeModel>()
        var result = realm.where(IncomeModel::class.java)
            .equalTo("year",year)
            .equalTo("month", month)
            .sort("day",Sort.DESCENDING)
            .findAll()
        for (c in result)
            list.add(c)
        return list
    }

    fun readCostList(year:Int,month:Int): ArrayList<CostModel>
    {
        var list = ArrayList<CostModel>()
        var result = realm.where(CostModel::class.java)
            .equalTo("year",year)
            .equalTo("month", month)
            .sort("day",Sort.DESCENDING)
            .findAll()
        for (c in result)
            list.add(c)
        return list
    }

}
