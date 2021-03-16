package com.jeanbarrossilva.andre.core

import java.io.Serializable
import java.time.LocalDateTime

data class SubareaIndicatorChange(val indicator: SubareaIndicator): Serializable {
	val dateTime = LocalDateTime.now()
	
	override fun toString() = "SubareaIndicatorChange(indicator=$indicator, date=$dateTime)"
}