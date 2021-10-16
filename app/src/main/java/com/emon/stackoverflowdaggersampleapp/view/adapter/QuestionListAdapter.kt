package com.emon.stackoverflowdaggersampleapp.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.emon.stackoverflowdaggersampleapp.R
import com.emon.stackoverflowdaggersampleapp.data.questionList.Item
import com.emon.stackoverflowdaggersampleapp.databinding.LayoutQuestionBinding
import com.emon.stackoverflowdaggersampleapp.view.screen.ItemClickListener


class QuestionListAdapter(val questions: List<Item>,val callBack: ItemClickListener): RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder:RecyclerView.ViewHolder{
        var binding:LayoutQuestionBinding?=null
        constructor(binding: LayoutQuestionBinding):super(binding.root){
            this.binding=binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        var binding: LayoutQuestionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_question,
            parent,
            false
        )
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.binding!!.tvQuestion.text=questions[position].title
        holder.binding!!.root.setOnClickListener {
            callBack.goToQuestionDetails("${questions[position]!!.question_id!!}")
        }
    }

    override fun getItemCount()=questions.size
}