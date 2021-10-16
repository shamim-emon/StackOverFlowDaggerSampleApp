package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.composition.AppCompositionRoot
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository

open class BaseActivity: AppCompatActivity() {

    protected lateinit var  compositionRoot: AppCompositionRoot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositionRoot=(application as BaseApplication).appCompositionRoot
    }
}