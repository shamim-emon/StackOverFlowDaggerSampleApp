package com.emon.stackoverflowdaggersampleapp.data.questionDetails

data class SingleQuestionResponseSchema(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)