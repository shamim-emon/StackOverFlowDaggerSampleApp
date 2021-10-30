package com.emon.stackoverflowdaggersampleapp.viewModel

import androidx.lifecycle.ViewModel
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import javax.inject.Inject

class ViewModelTwo @Inject constructor(private val repository: RestRepository): ViewModel() {
}