package com.puls.home.navigation.global

import cafe.adriel.voyager.core.registry.screenModule
import com.puls.home.presentation.ui.screen.home.HomeScreen
import com.puls.navigation.screen.SharedScreen

val featureHomeScreenModule = screenModule {
    register<SharedScreen.HomeScreen> {
        HomeScreen()
    }
}