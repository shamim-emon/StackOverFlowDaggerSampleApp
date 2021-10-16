package com.emon.stackoverflowdaggersampleapp.data.questionList

data class QuestionsListResponseSchema(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)