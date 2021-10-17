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
class PresentationModule(private val activityComponent: ActivityComponent) {


    @Provides fun provideScreensNavigator(): ScreensNavigator = activityComponent.provideScreensNavigator()
    @Provides fun provideDialogsNavigator(): DialogsNavigator = activityComponent.providesDialogsNavigator()
    @Provides fun provideRepository(): RestRepository =activityComponent.providesRepository()
    @Provides fun provideApplication():Application=activityComponent.provideApplication()
    @Provides fun provideActivity():Activity=activityComponent.providesActivity()
    @Provides fun provideFragmentManager():FragmentManager=activityComponent.providesFragmentManager()

}