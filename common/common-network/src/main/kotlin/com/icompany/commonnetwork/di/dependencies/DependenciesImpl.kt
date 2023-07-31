package com.icompany.commonnetwork.di.dependencies

import android.content.Context
import com.icompany.commondi.component.app.ApplicationComponentHolder
import com.icompany.commonnetwork.di.component.NetworkComponentInternal

internal class DependenciesImpl : NetworkComponentInternal.Dependencies {

    override val context: Context
        get() = ApplicationComponentHolder.get().context()
}