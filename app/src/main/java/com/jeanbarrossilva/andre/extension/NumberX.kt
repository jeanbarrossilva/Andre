package com.jeanbarrossilva.andre.extension

import android.content.Context
import android.util.TypedValue
import com.jeanbarrossilva.andre.extension.ContextX.converting
import kotlin.reflect.KClass

object NumberX {
    operator fun Number.compareTo(other: Number) = this.toFloat().compareTo(other.toFloat())
    
    @Suppress("UNCHECKED_CAST")
    @PublishedApi
    internal fun <T : Number> Number.to(numberClass: KClass<T>): T =
        when (numberClass) {
            Byte::class -> toByte()
            Float::class -> toFloat()
            Int::class -> toInt()
            Long::class -> toLong()
            Short::class -> toInt().toShort()
            else -> throw IllegalStateException()
        } as T

    fun Number.dp(context: Context?) =
        context?.converting(this to TypedValue.COMPLEX_UNIT_DIP) ?: 0

    inline fun <reified T : Number> Number.to() = to(T::class)
}