package com.puls.commonnetwork.di.component

import android.content.Context
import com.puls.commondi.component.base.DIComponent
import com.puls.commondi.holder.single.ComponentHolder
import com.puls.commonnetwork.di.dependencies.DependenciesImpl
import com.puls.commonnetwork.di.module.ConfigModule
import com.puls.commonnetwork.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

interface NetworkComponent : DIComponent {

    fun networkClient(): Retrofit
}

@Singleton
@Component(
    modules = [
        ConfigModule::class,
        NetworkModule::class,
    ],
    dependencies = [NetworkComponentInternal.Dependencies::class]
)
internal interface NetworkComponentInternal : NetworkComponent {

    interface Dependencies {
        val context: Context
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): NetworkComponentInternal
    }
}

object NetworkComponentHolder : ComponentHolder<NetworkComponent>() {

    override fun build(): NetworkComponent {

        return DaggerNetworkComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): NetworkComponentInternal = get() as NetworkComponentInternal
}
