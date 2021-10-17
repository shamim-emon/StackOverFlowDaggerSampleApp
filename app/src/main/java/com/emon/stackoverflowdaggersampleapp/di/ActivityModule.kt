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
class ActivityModule(private val appComponent: AppComponent, private val activity:Activity, private val fragmentManager: FragmentManager) {

    @Provides fun provideScreensNavigator(): ScreensNavigator = ScreensNavigator(activity)
    @Provides fun provideDialogsNavigator(): DialogsNavigator = DialogsNavigator(fragmentManager)
    @Provides fun provideRepository():RestRepository=appComponent.provideRestRepository()
    @Provides fun provideApplication():Application=appComponent.provideApplication()
    @Provides fun providesActivity()=activity
    @Provides fun providesFragmentManager()=fragmentManager



}