package com.emon.stackoverflowdaggersampleapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emon.stackoverflowdaggersampleapp.data.questionList.Item
import com.emon.stackoverflowdaggersampleapp.rest.Resource
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import dagger.Provides
import javax.inject.Inject
import javax.inject.Provider

class QuestionViewModel @Inject constructor(private val repository: RestRepository) : ViewModel() {

    private var questionListSchemaLiveData: MutableLiveData<Resource<List<Item>>> = MutableLiveData()
    private var questionDetailsSchemaLiveData: MutableLiveData<Resource<com.emon.stackoverflowdaggersampleapp.data.questionDetails.Item>> = MutableLiveData()

    fun getQuestionListSchema() = questionListSchemaLiveData
    suspend fun requestQuestionListSchema() {
        questionListSchemaLiveData.postValue(Resource.loading(null))
        try {
            var responseSchema = repository.fetchQuestionsListResponseSchema()
            questionListSchemaLiveData.postValue(Resource.success(responseSchema.body()!!.items))
        } catch (e: Exception) {
            questionListSchemaLiveData.postValue(Resource.error(null))
        }
    }

    fun getQuestionBody() = questionDetailsSchemaLiveData
    suspend fun requestQuestionBodySchema(id: String) {
        questionDetailsSchemaLiveData.postValue(Resource.loading(null))
        try {
            var responseSchema = repository.fetchQuestionsDetailsResponseSchema(id)
            questionDetailsSchemaLiveData.postValue(Resource.success(responseSchema!!.body()!!.items[0]))
        } catch (e: Exception) {
            questionDetailsSchemaLiveData.postValue(Resource.error(null))
        }

    }

}