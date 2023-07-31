package com.puls.commonnetwork.di.module

import com.puls.commonnetwork.config.NetworkConfig
import com.puls.commonnetwork.config.NetworkConfigImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ConfigModule {

    @Binds
    fun bindNetworkConfig(impl: NetworkConfigImpl): NetworkConfig
}