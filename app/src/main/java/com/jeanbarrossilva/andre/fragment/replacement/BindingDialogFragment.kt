package com.jeanbarrossilva.andre.fragment.replacement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

open class BindingDialogFragment<VB: ViewBinding>(private val bindingBlock: LayoutInflater.() -> VB):
	DialogFragment() {
	lateinit var binding: VB
		private set
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = bindingBlock(inflater)
		return binding.root
	}
}