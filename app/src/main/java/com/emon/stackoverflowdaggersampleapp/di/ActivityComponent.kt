package com.emon.stackoverflowdaggersampleapp.di

import android.app.Activity
import androidx.fragment.app.FragmentManager
import dagger.BindsInstance
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
      fun newPresentationComponent():PresentationComponent

      @Subcomponent.Builder
      interface Builder{
            @BindsInstance fun activity(activity: Activity):Builder
            @BindsInstance fun fragmentManager(fragmentManager: FragmentManager):Builder
            fun build():ActivityComponent
      }
}