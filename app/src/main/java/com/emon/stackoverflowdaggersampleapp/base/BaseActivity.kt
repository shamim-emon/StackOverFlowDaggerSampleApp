package com.emon.stackoverflowdaggersampleapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository

open class BaseActivity: AppCompatActivity() {

    protected lateinit var  repository:RestRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository=(application as BaseApplication).repository
    }
}