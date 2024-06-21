package com.example.brailleboard.utils

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

object Utils {

    fun hideStatusBar(activity: ComponentActivity){
        val windowInsetsController =
            WindowCompat.getInsetsController(activity.window, activity.window.decorView) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
    }

}