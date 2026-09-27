package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.AppsContainer
import com.example.amphibians.data.DefaultAppContainer

class AmphibiansApplication : Application() {

    lateinit var container : AppsContainer
    override fun onCreate (){
        super.onCreate()
        container = DefaultAppContainer()
    }
}