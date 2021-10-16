package com.emon.stackoverflowdaggersampleapp.dependencyInjection

import com.emon.stackoverflowdaggersampleapp.composition.PresentationCompositionRoot
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionListActivity
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel

class Injector(private  var presentationCompositionRoot: PresentationCompositionRoot) {

    fun inject(activity:QuestionListActivity){
        activity.viewModel= QuestionViewModel(presentationCompositionRoot.repository)
        activity.screensNavigator= ScreensNavigator(activity)
        activity.dialogsNavigator= DialogsNavigator(presentationCompositionRoot.fragmentManager)
    }
    fun inject(activity:QuestionDetailsActivity){
        activity.viewModel= QuestionViewModel(presentationCompositionRoot.repository)
        activity.screensNavigator= ScreensNavigator(activity)
        activity.dialogsNavigator= DialogsNavigator(presentationCompositionRoot.fragmentManager)
    }
}