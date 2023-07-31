package com.puls.home.di.component

import com.puls.commondi.component.base.DIComponent
import com.puls.commondi.holder.single.FeatureComponentHolder
import com.puls.commondi.module.CommonDiModule
import com.puls.commondi.util.DaggerViewModelProvider
import com.puls.home.di.dependencies.DependenciesImpl
import com.puls.home.di.module.ViewModelModule
import com.puls.home_domain.domain.usecase.users.GetAllUsersUseCase
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
