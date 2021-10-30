package com.emon.stackoverflowdaggersampleapp.di

import androidx.lifecycle.ViewModel
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel
import com.emon.stackoverflowdaggersampleapp.viewModel.ViewModelTwo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel::class)
    abstract fun myViewModel(viewModel: QuestionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelTwo::class)
    abstract fun myViewModel2(viewModel: ViewModelTwo): ViewModel
}