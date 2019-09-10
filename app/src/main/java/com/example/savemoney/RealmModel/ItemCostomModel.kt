package com.example.poolamochikarkonm.RealmModel

import android.graphics.drawable.Drawable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ItemCostomModel:RealmObject() {
    @PrimaryKey
    var id:Int=0
    var titel:String?=null
    var description:String?=null
    var image:Int?=null
    var background:String?=null
}