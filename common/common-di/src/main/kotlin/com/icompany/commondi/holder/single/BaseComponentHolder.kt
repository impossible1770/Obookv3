package com.icompany.commondi.holder.single

import com.icompany.commondi.component.base.DIComponent

/**
 *
 * Интерфейс базового поведения холдера предоставляющего компонет
 */
interface BaseComponentHolder<Component : DIComponent> {

    fun get(): Component

    fun set(component: Component)
}
