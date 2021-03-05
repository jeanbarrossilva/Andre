package com.jeanbarrossilva.andre.extension

object Extensions {
	fun <T> T.alsoIf(condition: Boolean, block: T.() -> T): T = if (condition) block(this) else this
}