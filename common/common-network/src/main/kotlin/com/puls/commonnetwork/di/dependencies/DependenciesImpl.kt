package com.puls.commonnetwork.di.dependencies

import android.content.Context
import com.puls.commondi.component.app.ApplicationComponentHolder
import com.puls.commonnetwork.di.component.NetworkComponentInternal

internal class DependenciesImpl : NetworkComponentInternal.Dependencies {

    override val context: Context
        get() = ApplicationComponentHolder.get().context()
}