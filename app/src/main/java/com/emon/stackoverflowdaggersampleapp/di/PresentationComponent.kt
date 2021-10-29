package com.emon.stackoverflowdaggersampleapp.di

import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionListActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {

    fun inject(activity:QuestionListActivity)
    fun inject(activity:QuestionDetailsActivity)
}