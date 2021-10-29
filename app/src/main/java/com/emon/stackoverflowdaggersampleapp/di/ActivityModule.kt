package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @ActivityScope
    @Binds abstract fun bindScreensNavigator(screensNavigatorImpl: ScreensNavigatorImpl):ScreensNavigator

    companion object {
        @Provides fun provideDialogsNavigator(fragmentManager: FragmentManager): DialogsNavigator = DialogsNavigator(fragmentManager)
    }

}