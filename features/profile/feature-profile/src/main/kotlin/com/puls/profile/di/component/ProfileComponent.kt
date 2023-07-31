package com.puls.profile.di.component

import com.puls.commondi.component.base.DIComponent
import com.puls.commondi.holder.single.FeatureComponentHolder
import com.puls.commondi.module.CommonDiModule
import com.puls.commondi.util.DaggerViewModelProvider
import com.puls.profile.di.dependencies.DependenciesImpl
import com.puls.profile.di.module.ViewModelModule
import com.puls.profile_domain.domain.usecase.getuser.GetUserByIdUseCase
import com.puls.profile_domain.domain.usecase.userspage.GetUsersPageUseCase
import dagger.Component

interface ProfileComponent : DIComponent, DaggerViewModelProvider

@Component(
    modules = [
        CommonDiModule::class,
        ViewModelModule::class,
    ],
    dependencies = [
        ProfileComponentInternal.Dependencies::class,
    ]
)
internal interface ProfileComponentInternal :
    ProfileComponent,
    ProfileScreenComponent {

    interface Dependencies {
        val getUserByIdUseCase: GetUserByIdUseCase
        val getUsersPageUseCase: GetUsersPageUseCase
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): ProfileComponentInternal
    }
}

object ProfileComponentHolder : FeatureComponentHolder<ProfileComponent>() {

    override fun build(): ProfileComponent {

        return DaggerProfileComponentInternal.factory().create(
            DependenciesImpl()
        )
    }

    internal fun getInternal(): ProfileComponentInternal = get() as ProfileComponentInternal
}
