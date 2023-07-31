package com.icompany.obook

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.puls.home.navigation.global.featureHomeScreenModule
import com.puls.profile.navigation.global.featureProfileScreenModule
import timber.log.Timber

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initGlobalNavigation()
        initTimber()
    }

    private fun initGlobalNavigation() {
        ScreenRegistry {
            featureProfileScreenModule()
            featureHomeScreenModule()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}