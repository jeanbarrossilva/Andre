package com.jeanbarrossilva.andre.interop

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import java.util.*

interface AndreChartEntry<O> {
	val id: UUID get() = UUID.randomUUID()
	val title: String
	val icon: Drawable
	
	@get:FloatRange(from = 0.0, to = 1.0)
	val value: Float
	
	@get:ColorInt
	val color: Int
	
	val original: O
}