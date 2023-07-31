package com.puls.profile_domain.di.dependencies

import com.puls.commonnetwork.di.component.NetworkComponentHolder
import com.puls.profile_domain.di.component.ProfileDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : ProfileDomainComponentInternal.Dependencies {

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}