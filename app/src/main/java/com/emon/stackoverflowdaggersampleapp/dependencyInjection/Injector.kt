package com.emon.stackoverflowdaggersampleapp.dependencyInjection

import com.emon.stackoverflowdaggersampleapp.composition.PresentationCompositionRoot
import com.emon.stackoverflowdaggersampleapp.rest.RestRepository
import com.emon.stackoverflowdaggersampleapp.view.dialog.DialogsNavigator
import com.emon.stackoverflowdaggersampleapp.view.navigation.ScreensNavigator
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionDetailsActivity
import com.emon.stackoverflowdaggersampleapp.view.screen.QuestionListActivity
import com.emon.stackoverflowdaggersampleapp.viewModel.QuestionViewModel
import java.lang.reflect.Field

class Injector(private  var presentationCompositionRoot: PresentationCompositionRoot) {

//    fun inject(activity:QuestionListActivity){
//        activity.viewModel= QuestionViewModel(presentationCompositionRoot.repository)
//        activity.screensNavigator= ScreensNavigator(activity)
//        activity.dialogsNavigator= DialogsNavigator(presentationCompositionRoot.fragmentManager)
//    }
//    fun inject(activity:QuestionDetailsActivity){
//        activity.viewModel= QuestionViewModel(presentationCompositionRoot.repository)
//        activity.screensNavigator= ScreensNavigator(activity)
//        activity.dialogsNavigator= DialogsNavigator(presentationCompositionRoot.fragmentManager)
//    }

    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for (annotation in fieldAnnotations) {
            if (annotation is Service) {
                return true
            }
        }
        return false
    }

    private fun getServiceForClass(type: Class<*>): Any {
        return when (type) {
            DialogsNavigator::class.java -> {
                presentationCompositionRoot.dialogsNavigator
            }
            ScreensNavigator::class.java -> {
                presentationCompositionRoot.screensNavigator
            }
            RestRepository::class.java -> {
                presentationCompositionRoot.repository
            }
            else -> {
                throw Exception("unsupported service type: $type")
            }
        }
    }

}