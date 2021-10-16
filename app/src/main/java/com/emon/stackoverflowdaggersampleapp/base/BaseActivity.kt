package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.composition.ActivityCompositionRoot
import com.emon.stackoverflowdaggersampleapp.composition.AppCompositionRoot
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository

open class BaseActivity: AppCompatActivity() {

    private lateinit var  appCompositionRoot: AppCompositionRoot
    protected lateinit var  compositionRoot: ActivityCompositionRoot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appCompositionRoot=(application as BaseApplication).appCompositionRoot
        compositionRoot= ActivityCompositionRoot(appCompositionRoot,this,supportFragmentManager)
    }
}