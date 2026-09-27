package com.example.googlebooks

import android.app.Application
import com.example.googlebooks.data.AppsContainer
import com.example.googlebooks.data.DefaultAppContainer

class GoogleBooksApplication : Application(){
    lateinit var container : AppsContainer
    private set

    override fun onCreate(){
        super.onCreate()
        container= DefaultAppContainer()
    }
}