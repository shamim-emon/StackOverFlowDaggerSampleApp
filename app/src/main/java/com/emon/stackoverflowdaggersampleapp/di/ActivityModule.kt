package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @Provides fun provideScreensNavigator(activity:Activity): ScreensNavigator = ScreensNavigator(activity)
    @Provides fun provideDialogsNavigator(fragmentManager: FragmentManager): DialogsNavigator = DialogsNavigator(fragmentManager)
}