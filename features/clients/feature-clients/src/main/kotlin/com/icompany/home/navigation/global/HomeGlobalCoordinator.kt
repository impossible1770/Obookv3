package com.icompany.home.navigation.global

import cafe.adriel.voyager.core.registry.screenModule
import com.icompany.home.presentation.ui.screen.home.HomeScreen
import com.icompany.navigation.screen.SharedScreen

val featureHomeScreenModule = screenModule {
    register<SharedScreen.HomeScreen> {
        HomeScreen()
    }
}