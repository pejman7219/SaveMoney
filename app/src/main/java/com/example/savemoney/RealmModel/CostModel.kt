package com.example.poolamochikarkonm.RealmModel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CostModel:RealmObject() {
    @PrimaryKey
    var id:Int=0
    var amount:String?=null
    var description:String?=null
    var time: String?=null
    var date:String?=null

}