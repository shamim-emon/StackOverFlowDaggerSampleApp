package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.data.Constants
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppCompositionRoot(val application: Application) {

    private  val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private var stackOverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    var repository: RestRepository = RestRepository(stackOverflowApi)

}