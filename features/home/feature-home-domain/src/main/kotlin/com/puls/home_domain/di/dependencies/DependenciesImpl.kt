package com.puls.home_domain.di.dependencies

import com.puls.commonnetwork.di.component.NetworkComponentHolder
import com.puls.home_domain.di.component.HomeDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : HomeDomainComponentInternal.Dependencies {

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}