package com.emon.stackoverflowdaggersampleapp.view.screen

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.emon.stackoverflowdaggersampleapp.R
import com.emon.stackoverflowdaggersampleapp.base.BaseActivity
import com.emon.stackoverflowdaggersampleapp.data.Constants
import com.emon.stackoverflowdaggersampleapp.databinding.ActivityQuestionListBinding
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_ERROR
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_LOADING
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_SUCCESS
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.rest.StackoverflowApi
import com.emon.stackoverflowdaggersampleapp.view.adapter.QuestionListAdapter
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.dialog.ServerErrorDialogFragment
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionListActivity : BaseActivity(), ItemClickListener {

    private lateinit var binding: ActivityQuestionListBinding

    private lateinit var viewModel: QuestionViewModel

    private lateinit var adapter: QuestionListAdapter

    private lateinit var dialogsNavigator: DialogsNavigator

    private lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question_list)

        dialogsNavigator= DialogsNavigator(supportFragmentManager)
        screensNavigator= ScreensNavigator(this)

        viewModel = QuestionViewModel(compositionRoot.repository)

        viewModel.getQuestionListSchema().observe(this, Observer {
            when (it.status) {
                STATUS_SUCCESS -> {
                    binding.progressCircular.visibility = GONE
                    adapter = QuestionListAdapter(it.data!!,this@QuestionListActivity)
                    binding.rvQuestions.adapter = adapter
                    binding.rvQuestions.layoutManager = LinearLayoutManager(this)
                }
                STATUS_LOADING -> {
                    binding.progressCircular.visibility = VISIBLE
                }
                STATUS_ERROR -> {
                    binding.progressCircular.visibility = GONE
                    dialogsNavigator.showNetworkErrorDialog()
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            viewModel.requestQuestionListSchema()
        }
    }



    override fun goToQuestionDetails(id: String) {
       screensNavigator.goToScreenDetails(id)
    }

    override fun onBackPressed() {
        screensNavigator.handleBackPress()
    }

}

interface ItemClickListener {
    fun goToQuestionDetails(id: String)
}