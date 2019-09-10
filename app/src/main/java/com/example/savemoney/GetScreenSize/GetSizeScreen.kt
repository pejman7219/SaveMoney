package com.example.savemoney.GetScreenSize

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

/**
 * Created by Admin on 11/12/2016.
 */
class GetSizeScreen(context: Context) {

    var dpi: Int = 0
    var height: Int = 0
    var width: Int = 0

    init {
        val displaymetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
        dpi = displaymetrics.densityDpi
        height = displaymetrics.heightPixels
        width = displaymetrics.widthPixels
    }
}
