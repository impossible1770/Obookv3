package com.puls.commondi.util

import androidx.lifecycle.ViewModelProvider

interface DaggerViewModelProvider {

    fun provideVF(): ViewModelProvider.Factory
}