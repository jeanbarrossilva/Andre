package com.jeanbarrossilva.andre.extension

import android.content.Context
import android.util.TypedValue
import com.jeanbarrossilva.andre.extension.ContextX.converting
import kotlin.reflect.KClass

object NumberX {
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

    fun Number.dp(context: Context) = context.converting<Int>(this to TypedValue.COMPLEX_UNIT_DIP)

    fun Number.sp(context: Context) = context.converting<Float>(this to TypedValue.COMPLEX_UNIT_SP)

    inline fun <reified T : Number> Number.to() = to(T::class)
}