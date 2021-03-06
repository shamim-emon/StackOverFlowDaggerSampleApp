package com.emon.stackoverflowdaggersampleapp.view.screen

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.emon.stackoverflowdaggersampleapp.R
import com.emon.stackoverflowdaggersampleapp.base.BaseActivity
import com.emon.stackoverflowdaggersampleapp.databinding.ActivityQuestionDetailsBinding
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_ERROR
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_LOADING
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_SUCCESS
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigatorImpl
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel
import com.emon.stackoverflowdaggersampleapp.viewModel.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionDetailsActivity : BaseActivity() {

    private lateinit var questionId:String

    private lateinit var binding:ActivityQuestionDetailsBinding

    private  lateinit var viewModel: QuestionViewModel

    @Inject
    lateinit var restRepository: RestRepository
    @Inject
    lateinit var dialogsNavigator:DialogsNavigator
    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @Inject lateinit var viewmodelFactory:ViewModelFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_question_details)

        injector.inject(this)

        questionId=intent.getStringExtra("question_id")!!
        viewModel= ViewModelProvider(this,viewmodelFactory).get(QuestionViewModel::class.java)
        viewModel.getQuestionBody().observe(this, Observer {
            when(it.status){
                STATUS_SUCCESS->{
                    binding.progressCircular.visibility=GONE

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        binding.questionDetails.setText(Html.fromHtml(it.data.toString(), Html.FROM_HTML_MODE_COMPACT));
                    } else {
                        binding.questionDetails.setText(Html.fromHtml(it.data.toString()));
                    }
                }
                STATUS_LOADING->{
                    binding.progressCircular.visibility= VISIBLE
                }
                STATUS_ERROR->{
                    binding.progressCircular.visibility=GONE
                    dialogsNavigator.showNetworkErrorDialog()
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            viewModel.requestQuestionBodySchema(questionId)
        }
    }

    override fun onBackPressed() {
        screensNavigator.handleBackPress()
    }

}