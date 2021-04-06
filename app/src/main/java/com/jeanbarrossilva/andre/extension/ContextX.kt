package com.jeanbarrossilva.andre.extension

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleableRes
import androidx.core.content.res.use
import androidx.core.content.withStyledAttributes
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.NumberX.to

object ContextX {
	val Context.isSystemInDarkTheme get() = resources.getBoolean(R.bool.isSystemInDarkTheme)
	val Context.layoutInflater: LayoutInflater get() = LayoutInflater.from(this)
	
	@PublishedApi
	internal inline infix fun <reified T : Number> Context.converting(
		conversion: Pair<Number, Int>
	): T {
		val (value, unit) = conversion
		return TypedValue.applyDimension(unit, value.toFloat(), resources.displayMetrics).to()
	}
	
	infix fun Context.colorOf(@AttrRes attrRes: Int) =
		obtainStyledAttributes(intArrayOf(attrRes)).use { it.getColor(0, Color.TRANSPARENT) }
	
	fun Context.withStyledAttributes(
		attrs: AttributeSet?,
		defStyleAttr: Int,
		@StyleableRes styleableRes: IntArray,
		onEachIndex: TypedArray.(Int) -> Unit
	) = withStyledAttributes(attrs, styleableRes, defStyleAttr, 0) {
		for (index in 0..indexCount)
			onEachIndex(this, index)
	}
}