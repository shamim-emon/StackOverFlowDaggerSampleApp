package com.emon.stackoverflowdaggersampleapp.di

import android.app.Application
import com.emon.stackoverflowdaggersampleapp.data.Constants
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides fun provideRetrofit():Retrofit{
       return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides fun provideStackOverFlowApi(retrofit: Retrofit)=retrofit.create(StackoverflowApi::class.java)

    @Provides fun provideRestRepository(stackoverflowApi: StackoverflowApi): RestRepository = RestRepository(stackoverflowApi)
    @Provides fun provideApplication()=application

}