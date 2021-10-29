package com.emon.stackoverflowdaggersampleapp.view.navigation

import android.app.Activity
import android.content.Intent
import com.emon.stackoverflowdaggersampleapp.di.ActivityScope
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity
import javax.inject.Inject


class  ScreensNavigatorImpl  @Inject constructor(val activity: Activity) :ScreensNavigator{

    override fun goToScreenDetails(id:String){
        var intent = Intent(activity, QuestionDetailsActivity::class.java).also { it.putExtra("question_id", id) }
        activity.startActivity(intent)
    }

    override fun handleBackPress(){
        activity.finish()
    }
}