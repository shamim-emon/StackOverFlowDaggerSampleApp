package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun provideScreensNavigator(): ScreensNavigator
    fun provideDialogsNavigator(): DialogsNavigator
    fun provideRepository(): RestRepository
}