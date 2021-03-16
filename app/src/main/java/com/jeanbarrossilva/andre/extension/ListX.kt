package com.jeanbarrossilva.andre.extension

import com.jeanbarrossilva.andre.extension.NumberX.compareTo

object ListX {
	fun <N: Number> List<N>.greater(): N {
		var greater = first()
		for (number in this)
			if (number > greater)
				greater = number
		return greater
	}
}