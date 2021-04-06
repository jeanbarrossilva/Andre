package com.jeanbarrossilva.andre.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections

object NavControllerX {
	fun NavController.navigateOnce(forbiddenDestinationId: Int, directions: NavDirections) {
		if (currentDestination?.id != forbiddenDestinationId)
			navigate(directions)
	}
}