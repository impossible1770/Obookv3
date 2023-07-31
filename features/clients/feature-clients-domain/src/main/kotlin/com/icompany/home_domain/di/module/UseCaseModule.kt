package com.icompany.home_domain.di.module

import com.icompany.home_domain.domain.usecase.users.GetAllUsersUseCase
import com.icompany.home_domain.domain.usecase.users.GetAllUsersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCaseModule {

    @Binds
    fun getAllUsersUseCase(impl: GetAllUsersUseCaseImpl): GetAllUsersUseCase
}