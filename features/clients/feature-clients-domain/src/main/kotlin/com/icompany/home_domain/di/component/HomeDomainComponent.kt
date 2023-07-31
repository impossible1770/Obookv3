package com.icompany.home_domain.di.component

import com.icompany.commondi.component.base.DIComponent
import com.icompany.commondi.holder.single.FeatureComponentHolder
import com.icompany.home_domain.di.dependencies.DependenciesImpl
import com.icompany.home_domain.di.module.NetworkModule
import com.icompany.home_domain.di.module.RepositoryModule
import com.icompany.home_domain.di.module.UseCaseModule
import com.icompany.home_domain.domain.usecase.users.GetAllUsersUseCase
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

        return com.icompany.home_domain.di.component.DaggerHomeDomainComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): HomeDomainComponentInternal = get() as HomeDomainComponentInternal
}
