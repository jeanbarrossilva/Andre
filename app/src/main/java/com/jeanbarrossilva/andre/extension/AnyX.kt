package com.jeanbarrossilva.andre.extension

object AnyX {
	fun <T> T.doIf(condition: T.() -> Boolean, block: T.() -> T) =
		if (condition(this)) block(this) else this
}