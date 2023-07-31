package com.icompany.home_domain.di.dependencies

import com.icompany.commonnetwork.di.component.NetworkComponentHolder
import com.icompany.home_domain.di.component.HomeDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : HomeDomainComponentInternal.Dependencies {

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}