package com.emon.stackoverflowdaggersampleapp.base

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.composition.AppCompositionRoot
import com.emon.stackoverflowdaggersampleapp.data.Constants
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApplication :Application() {

    lateinit var appCompositionRoot: AppCompositionRoot
    override fun onCreate() {
        super.onCreate()
        appCompositionRoot=AppCompositionRoot()
    }
}