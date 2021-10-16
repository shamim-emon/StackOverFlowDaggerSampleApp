package com.emon.stackoverflowdaggersampleapp.view.navigation

import android.app.Activity
import android.content.Intent
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity

class ScreensNavigator(val activity: Activity) {

    fun goToScreenDetails(id:String){
        var intent = Intent(activity, QuestionDetailsActivity::class.java).also { it.putExtra("question_id", id) }
        activity.startActivity(intent)
    }

    fun handleBackPress(){
        activity.finish()
    }
}