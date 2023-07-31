package com.icompany.obook

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.icompany.home.navigation.global.featureHomeScreenModule
import com.icompany.profile.navigation.global.featureProductsScreenModule
import timber.log.Timber

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initGlobalNavigation()
        initTimber()
    }

    private fun initGlobalNavigation() {
        ScreenRegistry {
            featureProductsScreenModule()
            featureHomeScreenModule()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}