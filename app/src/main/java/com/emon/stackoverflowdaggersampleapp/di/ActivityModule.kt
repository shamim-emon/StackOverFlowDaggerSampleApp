package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class ActivityModule {

    @ActivityScope
    @Binds abstract fun bindScreensNavigator(screensNavigatorImpl: ScreensNavigatorImpl):ScreensNavigator

    companion object {
        @Provides fun provideDialogsNavigator(fragmentManager: FragmentManager): DialogsNavigator = DialogsNavigator(fragmentManager)

        @Provides
        @Named("t1")
        fun testStringOne()="One"

        @Provides
        @Named("t2")
        fun testStringTwo()="Two"

    }

}