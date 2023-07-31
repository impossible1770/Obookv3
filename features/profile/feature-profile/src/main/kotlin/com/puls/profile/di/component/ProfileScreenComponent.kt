package com.puls.profile.di.component

import com.puls.profile.presentation.ui.screen.first.FirstProfileScreen
import com.puls.profile.presentation.ui.screen.second.SecondProfileScreen

internal interface ProfileScreenComponent {

    fun inject(fragment: FirstProfileScreen)

    fun inject(fragment: SecondProfileScreen)
}
