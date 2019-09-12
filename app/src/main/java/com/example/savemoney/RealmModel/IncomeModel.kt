package com.example.poolamochikarkonm.RealmModel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class IncomeModel:RealmObject() {
    @PrimaryKey
    var id:Int=0
    var amount:Int?=null
    var description:String?=null
    var title:String?=null
    var time: String?=null
    var year:Int?=null
    var month:Int?=null
    var day:Int?=null
    var date:String?=null
}