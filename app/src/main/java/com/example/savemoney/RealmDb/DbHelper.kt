package com.example.savemoney.RealmDb

import android.content.Context
import android.util.Log
import com.example.poolamochikarkonm.RealmModel.ItemCostomModel
import com.example.poolamochikarkonm.RealmModel.ItemIncomeModel
import io.realm.Realm

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
    }
