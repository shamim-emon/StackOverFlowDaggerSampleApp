package com.emon.stackoverflowdaggersampleapp.view.screen

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.emon.stackoverflowdaggersampleapp.R
import com.emon.stackoverflowdaggersampleapp.base.BaseActivity
import com.emon.stackoverflowdaggersampleapp.databinding.ActivityQuestionListBinding
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_ERROR
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_LOADING
import com.emon.stackoverflowdaggersampleapp.rest.Resource.Companion.STATUS_SUCCESS
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.adapter.QuestionListAdapter
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel
import com.emon.stackoverflowdaggersampleapp.viewModel.ViewModelFactory
import com.emon.stackoverflowdaggersampleapp.viewModel.ViewModelTwo
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class QuestionListActivity : BaseActivity(), ItemClickListener {

    private lateinit var binding: ActivityQuestionListBinding

    private lateinit var viewModel: QuestionViewModel
    private lateinit var viewModelTwo: ViewModelTwo
    @Inject
    lateinit var repository:RestRepository

    private lateinit var adapter: QuestionListAdapter

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @field:Named("t1")
    @Inject lateinit var strOne:String

    @field:Named("t2")
    @Inject lateinit var strTwo:String

    @Inject lateinit var viewmodelFactory:ViewModelFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question_list)


        injector.inject(this)

        viewModel= ViewModelProvider(this,viewmodelFactory).get(QuestionViewModel::class.java)
        viewModelTwo= ViewModelProvider(this,viewmodelFactory).get(ViewModelTwo::class.java)
        viewModel.getQuestionListSchema().observe(this, Observer {
            when (it.status) {
                STATUS_SUCCESS -> {
                    binding.progressCircular.visibility = GONE
                    adapter = QuestionListAdapter(it.data!!, this@QuestionListActivity)
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