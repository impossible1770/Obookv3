package com.puls.profile.navigation.global

import cafe.adriel.voyager.core.registry.screenModule
import com.puls.navigation.screen.SharedScreen
import com.puls.profile.presentation.ui.screen.first.FirstProfileScreen

val featureProfileScreenModule = screenModule {
    register<SharedScreen.ProfileScreen> {
        FirstProfileScreen()
    }
}
