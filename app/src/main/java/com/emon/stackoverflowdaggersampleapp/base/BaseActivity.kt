package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.di.*

open class BaseActivity: AppCompatActivity() {

    private  val  appCompositionRoot by lazy {
        (application as BaseApplication).appComponent

    }
    private val  activityCompositionRoot by lazy {
        appCompositionRoot
                .newActivityComponentBuilder()
                .fragmentManager(supportFragmentManager)
                .activity(this)
                .build()
    }

    private val compositionRoot by lazy {
        activityCompositionRoot.newPresentationComponent()
    }

    protected  val injector  get() = compositionRoot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}