package com.emon.stackoverflowdaggersampleapp.base

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.composition.AppCompositionRoot

class BaseApplication :Application() {

    lateinit var appCompositionRoot: AppCompositionRoot
    override fun onCreate() {
        super.onCreate()
        appCompositionRoot=AppCompositionRoot(this)
    }
}