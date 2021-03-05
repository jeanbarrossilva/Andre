package com.jeanbarrossilva.andre.viewmodel

import androidx.lifecycle.ViewModel
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.SkuDetails
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.ViewGroupX.propagate
import com.jeanbarrossilva.andre.fragment.GenerosityBoxFragment
import com.jeanbarrossilva.andre.ui.GenerosityBoxButton

class GenerosityBoxViewModel(private val fragment: GenerosityBoxFragment): ViewModel() {
	private fun showDialogOnFinishPurchase(result: BillingResult) {
	}
	
	fun propagateListener() =
		fragment.binding.buttonsLayout.propagate(isInclusive = false) {
			setOnClickListener(fragment)
		}
	
	fun onClick(button: GenerosityBoxButton) {
		val client =
			BillingClient
				.newBuilder(fragment.requireContext())
				.setListener { result, _ -> showDialogOnFinishPurchase(result) }
				.enablePendingPurchases()
				.build()
		val productId =
			when (button.id) {
				R.id.great_button -> "great"
				R.id.nice_button -> "nice"
				R.id.amazing_button -> "amazing"
				else -> null
			}!!
		val billingFlowParams =
			BillingFlowParams
				.newBuilder()
				.setSkuDetails(SkuDetails(productId))
				.build()
		
		client.launchBillingFlow(fragment.requireActivity(), billingFlowParams)
	}
}