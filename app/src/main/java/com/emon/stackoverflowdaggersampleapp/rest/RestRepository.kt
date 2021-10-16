package com.emon.stackoverflowdaggersampleapp.rest

class RestRepository(val stackoverflowApi: StackoverflowApi) {
    suspend fun fetchQuestionsListResponseSchema()=stackoverflowApi.lastActiveQuestions(20)
    suspend fun fetchQuestionsDetailsResponseSchema(id:String)=stackoverflowApi.questionDetails(id)
}