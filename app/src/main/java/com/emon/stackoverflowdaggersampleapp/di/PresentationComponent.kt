package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionListActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@PresentationScope
@Subcomponent
interface PresentationComponent {

    fun inject(activity:QuestionListActivity)
    fun inject(activity:QuestionDetailsActivity)
}