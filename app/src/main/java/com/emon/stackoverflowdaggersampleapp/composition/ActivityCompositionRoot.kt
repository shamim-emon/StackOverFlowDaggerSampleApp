package com.emon.stackoverflowdaggersampleapp.composition

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator

class ActivityCompositionRoot(private val appCompositionRoot: AppCompositionRoot,val activity:Activity,val fragmentManager: FragmentManager) {

    var screensNavigator: ScreensNavigator = ScreensNavigator(activity)
    var dialogsNavigator: DialogsNavigator = DialogsNavigator(fragmentManager)
    var repository:RestRepository=appCompositionRoot.repository
    var application=appCompositionRoot.application


}