package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.FragmentManager
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import dagger.Component
import javax.inject.Singleton


@ActivityScope
@Component(modules = [ActivityModule::class],dependencies = [AppComponent::class])
interface ActivityComponent {
    fun provideScreensNavigator(): ScreensNavigator
    fun providesDialogsNavigator(): DialogsNavigator
    fun providesRepository(): RestRepository
    fun provideApplication(): Application
    fun providesActivity():Activity
    fun providesFragmentManager():FragmentManager

}