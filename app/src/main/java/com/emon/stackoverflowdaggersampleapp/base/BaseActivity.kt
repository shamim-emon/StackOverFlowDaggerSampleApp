package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.composition.ActivityCompositionRoot
import com.emon.stackoverflowdaggersampleapp.composition.AppCompositionRoot
import com.emon.stackoverflowdaggersampleapp.composition.PresentationCompositionRoot
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository

open class BaseActivity: AppCompatActivity() {

    private  val  appCompositionRoot by lazy {
        (application as BaseApplication).appCompositionRoot
    }
    private val  activityCompositionRoot by lazy {
        ActivityCompositionRoot(appCompositionRoot,this,supportFragmentManager)
    }

    protected  val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }


}