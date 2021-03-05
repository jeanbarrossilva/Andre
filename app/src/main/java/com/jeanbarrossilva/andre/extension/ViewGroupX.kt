package com.jeanbarrossilva.andre.extension

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.reflect.KClass

object ViewGroupX {
    @Suppress("UNCHECKED_CAST")
    @PublishedApi
    internal fun <V : View> ViewGroup.find(isInclusive: Boolean, viewClass: KClass<V>): V? {
        var foundView: V? = null
        if (this::class == viewClass && isInclusive)
            foundView = this as V
        else
            for (child in children) {
                when {
                    child::class == viewClass -> {
                        foundView = child as V
                        break
                    }
                    child is ViewGroup ->
                        foundView = child.find(isInclusive = false, viewClass)
                }
                if (foundView != null)
                    break
            }
        return foundView
    }

    inline fun <reified T : View> ViewGroup.find(isInclusive: Boolean = true) =
        find(isInclusive, T::class)
    
    fun ViewGroup.propagate(isInclusive: Boolean = true, block: View.() -> Unit) {
        if (isInclusive)
            block(this)
        children.forEach { child ->
            if (child is ViewGroup)
                child.propagate(isInclusive = false, block)
        }
    }
}