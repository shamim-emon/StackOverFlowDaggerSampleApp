package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponentBuilder():ActivityComponent.Builder

    @Component.Builder
    interface Builder{
        @BindsInstance fun application(application: Application):Builder
        fun build():AppComponent
    }
}