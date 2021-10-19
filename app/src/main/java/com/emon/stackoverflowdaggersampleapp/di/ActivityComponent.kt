package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
      fun newPresentationComponent():PresentationComponent

}