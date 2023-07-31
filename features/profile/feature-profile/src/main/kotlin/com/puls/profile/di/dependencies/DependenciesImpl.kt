package com.puls.profile.di.dependencies

import com.puls.profile.di.component.ProfileComponentInternal
import com.puls.profile_domain.di.component.ProfileDomainComponentHolder
import com.puls.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.puls.profile_domain.domain.usecase.userspage.GetUsersPageUseCase

internal class DependenciesImpl : ProfileComponentInternal.Dependencies {

    override val getUserByIdUseCase: GetUserByIdUseCase
        get() = ProfileDomainComponentHolder.get().getUserByIdUseCase()

    override val getUsersPageUseCase: GetUsersPageUseCase
        get() = ProfileDomainComponentHolder.get().getUsersPageUseCase()
}