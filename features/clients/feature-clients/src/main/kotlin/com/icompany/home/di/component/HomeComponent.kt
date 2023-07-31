package com.icompany.home.di.component

import com.icompany.commondi.component.base.DIComponent
import com.icompany.commondi.holder.single.FeatureComponentHolder
import com.icompany.commondi.module.CommonDiModule
import com.icompany.commondi.util.DaggerViewModelProvider
import com.icompany.home.di.dependencies.DependenciesImpl
import com.icompany.home.di.module.ViewModelModule
import com.icompany.home_domain.domain.usecase.users.GetAllUsersUseCase
import dagger.Component

interface HomeComponent : DIComponent, DaggerViewModelProvider

@Component(
    modules = [
        CommonDiModule::class,
        ViewModelModule::class
    ],

    dependencies = [
        HomeComponentInternal.Dependencies::class,
    ]
)
internal interface HomeComponentInternal :
    HomeComponent,
    HomeScreenComponent {

    interface Dependencies {
        val getAllUsersUseCase: GetAllUsersUseCase
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): HomeComponentInternal
    }
}

object HomeComponentHolder : FeatureComponentHolder<HomeComponent>() {

    override fun build(): HomeComponent {

        return DaggerHomeComponentInternal.factory().create(
            DependenciesImpl(),
        )
    }

    internal fun getInternal(): HomeComponentInternal = get() as HomeComponentInternal
}
