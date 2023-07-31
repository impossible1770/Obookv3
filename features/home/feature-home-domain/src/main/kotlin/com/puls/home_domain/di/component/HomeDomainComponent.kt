package com.puls.home_domain.di.component

import com.puls.commondi.component.base.DIComponent
import com.puls.commondi.holder.single.FeatureComponentHolder
import com.puls.home_domain.di.dependencies.DependenciesImpl
import com.puls.home_domain.di.module.NetworkModule
import com.puls.home_domain.di.module.RepositoryModule
import com.puls.home_domain.di.module.UseCaseModule
import com.puls.home_domain.domain.usecase.users.GetAllUsersUseCase
import dagger.Component
import retrofit2.Retrofit

interface HomeDomainComponent : DIComponent {

    fun getAllUsersUseCase(): GetAllUsersUseCase
}

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ],

    dependencies = [
        HomeDomainComponentInternal.Dependencies::class,
    ]
)
internal interface HomeDomainComponentInternal : HomeDomainComponent {

    interface Dependencies {
        val retrofit: Retrofit
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): HomeDomainComponentInternal
    }
}

object HomeDomainComponentHolder : FeatureComponentHolder<HomeDomainComponent>() {

    override fun build(): HomeDomainComponent {

        return DaggerHomeDomainComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): HomeDomainComponentInternal = get() as HomeDomainComponentInternal
}
