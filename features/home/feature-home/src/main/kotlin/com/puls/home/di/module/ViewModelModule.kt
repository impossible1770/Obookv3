package com.puls.home.di.module

import androidx.lifecycle.ViewModel
import com.puls.commondi.util.ViewModelKey
import com.puls.home.presentation.ui.screen.home.HomeViewModel
import com.puls.home.presentation.ui.screen.home.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModelImpl): ViewModel
}
