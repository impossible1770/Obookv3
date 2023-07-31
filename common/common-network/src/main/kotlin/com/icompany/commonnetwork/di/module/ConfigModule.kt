package com.icompany.commonnetwork.di.module

import com.icompany.commonnetwork.config.NetworkConfig
import com.icompany.commonnetwork.config.NetworkConfigImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ConfigModule {

    @Binds
    fun bindNetworkConfig(impl: NetworkConfigImpl): NetworkConfig
}