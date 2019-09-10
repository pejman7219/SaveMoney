package com.example.poolamochikarkonm.RealmModel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ItemIncomeModel:RealmObject() {
    @PrimaryKey
    var id:Int=0
    var titel:String?=null
    var description:String?=null
    var image:Int?=null
    var background:String?=null
}