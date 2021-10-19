package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule):ActivityComponent
}