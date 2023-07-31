package com.puls.commondi.component.app

import com.puls.commondi.holder.single.DataComponentHolder

object ApplicationComponentHolder :
    DataComponentHolder<ApplicationComponent, ApplicationComponentDependencies>() {

    override fun build(data: ApplicationComponentDependencies): ApplicationComponent =
        DaggerApplicationComponentInternal.factory().create(context = data.context)
}
