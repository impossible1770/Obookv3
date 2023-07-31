package com.icompany.home.di.dependencies

import com.icompany.home.di.component.HomeComponentInternal
import com.icompany.home_domain.di.component.HomeDomainComponentHolder
import com.icompany.home_domain.domain.usecase.users.GetAllUsersUseCase

internal class DependenciesImpl : HomeComponentInternal.Dependencies {

    override val getAllUsersUseCase: GetAllUsersUseCase
        get() = HomeDomainComponentHolder.get().getAllUsersUseCase()
}