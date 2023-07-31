package com.icompany.profile_domain.di.dependencies

import com.icompany.commonnetwork.di.component.NetworkComponentHolder
import com.icompany.profile_domain.di.component.ProfileDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : ProfileDomainComponentInternal.Dependencies {

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}