package com.jeanbarrossilva.andre.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.navOptions

object NavControllerX {
	private fun NavController.canNavigateFrom(initialDestinationId: Int) =
		currentDestination?.id == initialDestinationId
	
	fun NavController.navigateAnimating(
		destinationRes: Int,
		enterAnimationRes: Int = android.R.anim.fade_in,
		exitAnimationRes: Int = android.R.anim.fade_in,
		popEnterAnimationRes: Int = enterAnimationRes,
		popExitAnimationRes: Int = exitAnimationRes
	) = navigate(destinationRes, null, navOptions {
		anim {
			enter = enterAnimationRes
			exit = exitAnimationRes
			popEnter = popEnterAnimationRes
			popExit = popExitAnimationRes
		}
	})
	
	@JvmName("navigateOnceToDirections")
	fun NavController.navigateOnceFrom(navigation: Pair<Int, NavDirections>) =
		navigation.let { (initialDestinationId, directions) ->
			if (canNavigateFrom(initialDestinationId))
				navigate(directions)
		}
	
	@JvmName("navigateOnceWithAction")
	fun NavController.navigateOnceFrom(navigation: Pair<Int, Int>) =
		navigation.let { (initialDestinationId, actionRes) ->
			if (canNavigateFrom(initialDestinationId))
				navigate(actionRes)
		}
}