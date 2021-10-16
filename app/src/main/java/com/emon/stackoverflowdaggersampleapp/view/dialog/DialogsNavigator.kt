package com.emon.stackoverflowdaggersampleapp.view.dialog

import androidx.fragment.app.FragmentManager

class DialogsNavigator(val fragmentManager: FragmentManager) {

    fun showNetworkErrorDialog(){
        fragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }
}