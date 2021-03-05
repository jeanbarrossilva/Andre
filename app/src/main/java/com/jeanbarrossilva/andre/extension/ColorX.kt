package com.jeanbarrossilva.andre.extension

import android.graphics.Color
import kotlin.random.Random

object ColorX {
	fun randomColor(): Int {
		val (red, green, blue) =
			Triple(
				Random.nextInt(until = 256),
				Random.nextInt(until = 256),
				Random.nextInt(until = 256)
			)
		return Color.rgb(red, green, blue)
	}
}