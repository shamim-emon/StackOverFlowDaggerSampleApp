package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.di.*

open class BaseActivity: AppCompatActivity() {

    private  val  appCompositionRoot by lazy {
        (application as BaseApplication).appCompositionRoot
    }
    private val  activityCompositionRoot by lazy {
        //ActivityModule(appCompositionRoot,this,supportFragmentManager)
        DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(appCompositionRoot,this,supportFragmentManager))
            .build()
    }

    private val compositionRoot by lazy {
        //PresentationModule(activityCompositionRoot)
        DaggerPresentationComponent
            .builder()
            .presentationModule(PresentationModule(activityCompositionRoot))
            .build()
    }

    protected lateinit var injector: Injector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector= Injector(compositionRoot)
    }


}