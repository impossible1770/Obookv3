package com.icompany.commondi.holder.single

import com.icompany.commondi.component.base.DIComponent
import com.icompany.commondi.holder.ClearedComponentHolder

/**
 *
 * Позволяет получить компонент. Если компонента нет то создается новый
 */
abstract class ComponentHolder<Component : DIComponent> :
    BaseComponentHolder<Component>,
    ClearedComponentHolder {

    private var component: Component? = null

    override fun get(): Component {
        return component ?: build().also {
            component = it
        }
    }

    override fun set(component: Component) {
        this.component = component
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
