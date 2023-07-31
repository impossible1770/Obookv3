package com.puls.commondi.module

import androidx.lifecycle.ViewModelProvider
import com.puls.commondi.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface CommonDiModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
