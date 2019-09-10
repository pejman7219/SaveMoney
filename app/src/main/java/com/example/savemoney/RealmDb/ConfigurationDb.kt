package com.example.poolamochikarkonm.RealmDb

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class ConfigurationDb:Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config=RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().name("RealmDB").build()
        Realm.setDefaultConfiguration(config)
    }
}