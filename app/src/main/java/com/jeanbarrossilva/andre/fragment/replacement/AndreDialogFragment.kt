package com.jeanbarrossilva.andre.fragment.replacement

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.core.view.setPadding
import androidx.viewbinding.ViewBinding
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.NumberX.dp

open class AndreDialogFragment<VB: ViewBinding>(bindingBlock: LayoutInflater.() -> VB):
	BindingDialogFragment<VB>(bindingBlock) {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	) = super.onCreateView(inflater, container, savedInstanceState).apply {
		setPadding(30.dp(context))
	}
	
	override fun onCreateDialog(savedInstanceState: Bundle?) =
		super.onCreateDialog(savedInstanceState).apply {
			setOnShowListener {
				window?.attributes?.gravity = Gravity.CENTER
				window?.setLayout(context.resources.displayMetrics.widthPixels - 100, WRAP_CONTENT)
				window?.setBackgroundDrawableResource(R.drawable.bg_andre_dialog_fragment)
			}
		}
}