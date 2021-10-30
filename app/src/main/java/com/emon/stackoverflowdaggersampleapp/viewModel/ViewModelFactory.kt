package com.emon.stackoverflowdaggersampleapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val questionViewModelProvider: Provider<QuestionViewModel>,
    private val viewModelTwoProvider: Provider<ViewModelTwo>
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            QuestionViewModel::class.java -> questionViewModelProvider.get() as T
            ViewModelTwo::class.java -> viewModelTwoProvider.get() as T
            else -> throw RuntimeException("Unsupported class type->$modelClass")
        }

    }

}