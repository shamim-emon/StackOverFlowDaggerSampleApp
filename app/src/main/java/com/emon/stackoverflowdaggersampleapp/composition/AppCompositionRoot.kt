package com.emon.stackoverflowdaggersampleapp.composition

import com.emon.stackoverflowdaggersampleapp.data.Constants
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppCompositionRoot {

    private  val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private lateinit var stackOverflowApi: StackoverflowApi
    lateinit var repository: RestRepository

    init {
        stackOverflowApi = retrofit.create(StackoverflowApi::class.java)
        repository = RestRepository(stackOverflowApi)
    }
}