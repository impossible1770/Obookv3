package com.puls.composemultimoduletemplate.di.component.main

import com.puls.composemultimoduletemplate.presentation.ui.activity.MainActivity

internal interface AppActivityComponent {

    fun inject(activity: MainActivity)
}
