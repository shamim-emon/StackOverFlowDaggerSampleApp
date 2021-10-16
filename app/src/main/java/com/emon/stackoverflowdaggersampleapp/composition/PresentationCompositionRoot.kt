package com.emon.stackoverflowdaggersampleapp.composition

import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    var screensNavigator: ScreensNavigator = activityCompositionRoot.screensNavigator
    var dialogsNavigator: DialogsNavigator = activityCompositionRoot.dialogsNavigator
    var repository: RestRepository =activityCompositionRoot.repository
    var application=activityCompositionRoot.application
    var activity=activityCompositionRoot.activity
    var fragmentManager=activityCompositionRoot.fragmentManager

}