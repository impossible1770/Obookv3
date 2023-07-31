package com.puls.home.di.dependencies

import com.puls.home.di.component.HomeComponentInternal
import com.puls.home_domain.di.component.HomeDomainComponentHolder
import com.puls.home_domain.domain.usecase.users.GetAllUsersUseCase

internal class DependenciesImpl : HomeComponentInternal.Dependencies {

    override val getAllUsersUseCase: GetAllUsersUseCase
        get() = HomeDomainComponentHolder.get().getAllUsersUseCase()
}