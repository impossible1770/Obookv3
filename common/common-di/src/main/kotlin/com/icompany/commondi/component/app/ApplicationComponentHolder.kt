package com.icompany.commondi.component.app

import com.icompany.commondi.holder.single.DataComponentHolder

object ApplicationComponentHolder :
    DataComponentHolder<ApplicationComponent, ApplicationComponentDependencies>() {

    override fun build(data: ApplicationComponentDependencies): ApplicationComponent =
        DaggerApplicationComponentInternal.factory().create(context = data.context)
}
