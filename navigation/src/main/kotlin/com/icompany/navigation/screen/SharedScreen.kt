package com.icompany.navigation.screen

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object AuthorizationScreen : SharedScreen()
    object HomeScreen : SharedScreen()
    object Products : SharedScreen()
}