package com.emon.stackoverflowdaggersampleapp.base

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.di.AppComponent
import com.emon.stackoverflowdaggersampleapp.di.AppModule
import com.emon.stackoverflowdaggersampleapp.di.DaggerAppComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this as Application)
                .build()

    }
}